package com.example.composeavanzado.screens

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.composeavanzado.navigation.AppScreens
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel : ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _loginEnable = MutableLiveData<Boolean>()
    val loginEnable: LiveData<Boolean> = _loginEnable

    fun onLoginChange(email: String, password: String) {
        _email.value = email
        _password.value = password
        _loginEnable.value = isValidEmail(email) && isValidPassword(password)
    }

    private fun isValidPassword(password: String): Boolean = password.length > 6

    private fun isValidEmail(email: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()

    fun onLoginSelected(
        navController: NavController,
        auth: FirebaseAuth,
        email: String,
        password: String
    ) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener() {
            if (it.isSuccessful) {
                navController.navigate(route = AppScreens.Main.route) {
                    popUpTo(AppScreens.Login.route) {
                        inclusive = true
                    } // Elimina la LoginScreen del stack navegable
                }
            } else {
                // Mostrar error de login
            }
        }
    }
}