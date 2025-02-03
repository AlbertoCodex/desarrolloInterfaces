package com.example.composeavanzado.screens.login

import android.content.Context
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.composeavanzado.R
import com.example.composeavanzado.data.UserData
import com.example.composeavanzado.navigation.AppScreens
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseAuthRecentLoginRequiredException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.firestore.FirebaseFirestore

class RegisterViewModel : ViewModel() {
    private val collection_users = "Usuarios"

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _pais = MutableLiveData<String>()
    val pais: LiveData<String> = _pais

    private val _telefono = MutableLiveData<String>()
    val telefono: LiveData<String> = _telefono

    private val _loginEnable = MutableLiveData<Boolean>()
    val loginEnable: LiveData<Boolean> = _loginEnable

    private val _showDialog = MutableLiveData<Boolean>()
    val showDialog: LiveData<Boolean> = _showDialog

    private val _errorDialog = MutableLiveData<String>()
    val errorDialog: LiveData<String> = _errorDialog

    fun onRegisterChange(email: String, password: String, pais:String, telefono: String) {
        _email.value = email
        _password.value = password
        _pais.value = pais
        _telefono.value = telefono
        _loginEnable.value = isValidEmail(email) && isValidPassword(password) && isValidPais(pais) && isValidTelefono(telefono)
    }

    private fun isValidPassword(password: String): Boolean = password.length > 6

    private fun isValidEmail(email: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()

    private fun isValidPais(pais: String): Boolean = pais.length >= 3
    private fun isValidTelefono(telefono: String): Boolean = telefono.length == 9

    fun setShowDialogFalse() {
        _showDialog.value = false
    }

    fun onRegisterSelected(
        navController: NavController,
        auth: FirebaseAuth,
        email: String,
        password: String,
        pais: String,
        telefono: String,
        context: Context,
        db:FirebaseFirestore,
    ) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener() {
            if (it.isSuccessful) {
                createUser(db, email, password, pais, telefono)
                navController.navigate(route = AppScreens.Login.route)
            } else {
                _errorDialog.value = getFirebaseAuthErrorMessage(it.exception, context)
                _showDialog.value = true
            }
        }
    }

    private fun createUser(db: FirebaseFirestore, email: String, password: String, pais:String, telefono: String) {
        val user = UserData(email, password, pais, telefono)
        db.collection(collection_users).add(user)
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