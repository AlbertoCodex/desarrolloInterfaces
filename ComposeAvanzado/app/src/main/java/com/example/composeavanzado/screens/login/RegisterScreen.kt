package com.example.composeavanzado.screens.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseAuth
import androidx.compose.ui.platform.LocalContext

@Composable
fun RegisterScreen(navController: NavHostController, viewModel: LoginViewModel, auth: FirebaseAuth) {
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)) {
        Register(Modifier.align(Alignment.Center), navController, viewModel, auth)
    }
}

@Composable
fun Register(
    modifier: Modifier,
    navController: NavHostController,
    viewModel: LoginViewModel,
    auth: FirebaseAuth
) {
    val email : String by viewModel.email.observeAsState(initial = "")
    val password : String by viewModel.password.observeAsState(initial = "")
    val loginEnable:Boolean by viewModel.loginEnable.observeAsState(initial = false)
    val showDialog:Boolean by viewModel.showDialog.observeAsState(initial = false)
    val errorDialog by viewModel.errorDialog.observeAsState("")
    val context = LocalContext.current

    Column(modifier = modifier) {
        EmailField(email) {viewModel.onLoginChange(it, password)}
        Spacer(modifier = Modifier.padding(4.dp))
        PasswordField(password) {viewModel.onLoginChange(email, it)}
        Spacer(modifier = Modifier.padding(8.dp))
        // Add mas campos de informacion
        Spacer(modifier = Modifier.padding(16.dp))
        SendButton(loginEnable) { viewModel.onRegisterSelected(navController, auth, email, password, context) }
        ErrorDialog(showDialog, { viewModel.setShowDialogFalse() }, errorDialog)
    }
}

@Composable
fun SendButton(loginEnable:Boolean, onRegisterSelected: () -> Unit) {
    Button(
        onClick = {onRegisterSelected()},
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(
            disabledContainerColor = Color.Gray,
            disabledContentColor = Color.White,
            containerColor = Color.Blue,
            contentColor = Color.White
        ),
        enabled = loginEnable
    ) {
        Text(text = "Registrar Usuario")
    }
}