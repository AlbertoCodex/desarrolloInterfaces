package com.example.composeavanzado.screens.perfil

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.composeavanzado.R
import com.example.composeavanzado.screens.home.SootheBottomNavigation
import com.example.composeavanzado.screens.login.ErrorDialog
import com.example.composeavanzado.screens.login.PaisField
import com.example.composeavanzado.screens.login.PasswordField
import com.example.composeavanzado.screens.login.TelefonoField
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun ProfileScreen(
    navController: NavHostController,
    viewModel: ProfileViewModel,
    db: FirebaseFirestore,
    auth: FirebaseAuth
) {
    val userEmail = auth.currentUser?.email.orEmpty()
    val isLoading by viewModel.isLoading.observeAsState(true)

    Scaffold(
        bottomBar = { SootheBottomNavigation(navController = navController) } // Agregar la bottom bar
    ) { padding ->
        Box(
            Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(padding)
        ) {
            if (isLoading) {
                if (userEmail.isNotEmpty()) {
                    viewModel.getUserByEmail(db, userEmail)
                }
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            } else {
                Profile(Modifier.align(Alignment.Center), navController, viewModel, db)
            }
        }
    }
}

@Composable
fun Profile(
    modifier: Modifier,
    navController: NavHostController,
    viewModel: ProfileViewModel,
    db: FirebaseFirestore,
) {
    val email = viewModel.email.observeAsState().value ?: ""
    val password = viewModel.password.observeAsState().value ?: ""
    val pais = viewModel.pais.observeAsState().value ?: ""
    val telefono = viewModel.telefono.observeAsState().value ?: ""
    val loginEnable:Boolean by viewModel.loginEnable.observeAsState(initial = false)
    val showDialog:Boolean by viewModel.showDialog.observeAsState(initial = false)
    val errorDialog:String by viewModel.errorDialog.observeAsState("")

    Column(modifier = modifier) {
        IconImage(modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(16.dp))
        EmailProfileField(email) { viewModel.onProfileChange(it, password, pais, telefono) }
        Spacer(modifier = Modifier.padding(4.dp))
        PasswordField(password) { viewModel.onProfileChange(email, it, pais, telefono) }
        Spacer(modifier = Modifier.padding(8.dp))
        // Add mas campos de informacion
        PaisField(pais) { viewModel.onProfileChange(email, password, it, telefono) }
        Spacer(modifier = Modifier.padding(8.dp))
        TelefonoField(telefono) { viewModel.onProfileChange(email, password, pais, it) }
        Spacer(modifier = Modifier.padding(16.dp))
        ActualizarButton(loginEnable) { viewModel.onActualizarSelected(email, password, pais, telefono, db) }
        ErrorDialog(showDialog, { viewModel.setShowDialogFalse() }, errorDialog)
    }
}

@Composable
fun ActualizarButton(loginEnable: Boolean, onConfirm: () -> Unit) {
    val openDialog = remember { mutableStateOf(false) }
    Button(
        onClick = {openDialog.value = true},
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
        Text(text = "Actualizar información")
    }

    if (openDialog.value) {
        ConfirmDialog(
            onConfirm = {
                onConfirm()
                openDialog.value = false
            },
            onDismiss = {openDialog.value = false}
        )
    }
}

@Composable
fun ConfirmDialog(onConfirm: () -> Unit, onDismiss: () -> Unit) {
    androidx.compose.material3.AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Confirmar actualización") },
        text = { Text("¿Estás seguro de que quieres actualizar la información?") },
        confirmButton = {
            Button(onClick = onConfirm) {
                Text("Confirmar")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("Cancelar")
            }
        }
    )
}

@Composable
fun IconImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.profile_image),
        contentDescription = "Imagen Registro",
        modifier = modifier
            .clip(CircleShape)
    )
}

@Composable
fun EmailProfileField(email:String, onTextFieldChange:(String) -> Unit) {
    TextField(
        value = email,
        onValueChange = { onTextFieldChange(it) },
        modifier = Modifier.fillMaxWidth(),
        enabled = false,
        placeholder = { Text(text = "Email") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.Gray
        )
    )
}

