package com.example.composeavanzado.screens.login

import android.content.Context
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.composeavanzado.R
import com.example.composeavanzado.navigation.AppScreens
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseAuthRecentLoginRequiredException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException

class LoginViewModel : ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _loginEnable = MutableLiveData<Boolean>()
    val loginEnable: LiveData<Boolean> = _loginEnable

    private val _showDialog = MutableLiveData<Boolean>()
    val showDialog: LiveData<Boolean> = _showDialog

    private val _errorDialog = MutableLiveData<String>()
    val errorDialog: LiveData<String> = _errorDialog

    fun onLoginChange(email: String, password: String) {
        _email.value = email
        _password.value = password
        _loginEnable.value = isValidEmail(email) && isValidPassword(password)
    }

    private fun isValidPassword(password: String): Boolean = password.length > 6

    private fun isValidEmail(email: String): Boolean =
       Patterns.EMAIL_ADDRESS.matcher(email).matches()

    fun setShowDialogFalse() {
        _showDialog.value = false
    }

    fun onLoginSelected(
        navController: NavController,
        auth: FirebaseAuth,
        email: String,
        password: String,
        context: Context
    ) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener() {
            if (it.isSuccessful) {
                navController.navigate(route = AppScreens.Main.route) {
                    popUpTo(AppScreens.Login.route) {
                        inclusive = true
                    } // Elimina la LoginScreen del stack navegable
                }
            } else {
                _errorDialog.value = getFirebaseAuthErrorMessage(it.exception, context)
                _showDialog.value = true
            }
        }
    }

    fun onRegisterSelected(
        navController: NavController,
        auth: FirebaseAuth,
        email: String,
        password: String,
        context: Context
    ) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener() {
            if (it.isSuccessful) {
                navController.navigate(route = AppScreens.Login.route)
            } else {
                _errorDialog.value = getFirebaseAuthErrorMessage(it.exception, context)
                _showDialog.value = true
            }
        }
    }

    private fun getFirebaseAuthErrorMessage(exception: Exception?, context: Context): String {
        return when (exception) {
            is FirebaseAuthInvalidUserException -> context.getString(R.string.error_not_a_valid_email) // Usuario no existe
            is FirebaseAuthInvalidCredentialsException -> context.getString(R.string.error_invalid_credentials) // Login incorrecto
            is FirebaseAuthUserCollisionException -> context.getString(R.string.error_email_already_registered) // Email ya registrado
            is FirebaseAuthRecentLoginRequiredException -> context.getString(R.string.error_recent_login_required) // Sesión expirada
            else -> context.getString(R.string.error_unknown) // Error desconocido
        }
    }
}