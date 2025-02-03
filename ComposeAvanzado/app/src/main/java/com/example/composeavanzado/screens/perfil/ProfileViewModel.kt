package com.example.composeavanzado.screens.perfil

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeavanzado.data.UserData
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class ProfileViewModel: ViewModel() {
    private val collection_users = "Usuarios"
    private val _email = MutableLiveData<String?>()
    val email: LiveData<String?> = _email
    private val _password = MutableLiveData<String?>()
    val password: LiveData<String?> = _password
    private val _pais = MutableLiveData<String?>()
    val pais: LiveData<String?> = _pais
    private val _telefono = MutableLiveData<String?>()
    val telefono: LiveData<String?> = _telefono

    private val _loginEnable = MutableLiveData<Boolean>()
    val loginEnable: LiveData<Boolean> = _loginEnable
    private val _showDialog = MutableLiveData<Boolean>()
    val showDialog: LiveData<Boolean> = _showDialog
    private val _errorDialog = MutableLiveData<String>()
    val errorDialog: LiveData<String> = _errorDialog
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun onProfileChange(email: String, password: String, pais:String, telefono: String) {
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

    fun onActualizarSelected(
        email: String,
        password: String,
        pais: String,
        telefono: String,
        db: FirebaseFirestore,
    ) {
        viewModelScope.launch {
            try {
                val userQuery = db.collection(collection_users)
                    .whereEqualTo("email", email)
                    .get()
                    .await()

                if (userQuery.documents.isNotEmpty()) {
                    val userDocument = userQuery.documents.first()
                    db.collection(collection_users).document(userDocument.id)
                        .update(
                            mapOf(
                                "password" to password,
                                "pais" to pais,
                                "telefono" to telefono
                            )
                        )
                        .await()
                }
            } catch (e: Exception) {
                _errorDialog.postValue("Error al actualizar datos: ${e.message}")
                _showDialog.postValue(true)
            }
        }
    }

    fun getUserByEmail(db: FirebaseFirestore, email: String) {
        _isLoading.value = true
        viewModelScope.launch {
            val userResult: UserData? = withContext(Dispatchers.IO) {
                try {
                    val querySnapshot = db.collection(collection_users)
                        .whereEqualTo("email", email) // Filtrando por email
                        .get()
                        .await()

                    querySnapshot.documents.firstOrNull()?.toObject(UserData::class.java)
                } catch (e: Exception) {
                    null
                }
            }

            userResult?.let {
                _email.value = it.email
                _password.value = it.password
                _pais.value = it.pais
                _telefono.value = it.telefono
            }
            _isLoading.value = false
        }
    }


    /*
    private suspend fun getAllUsers(db: FirebaseFirestore):List<UserData> {
        return  try {
            db.collection(collection_users)
                .get()
                .await()
                .documents
                .mapNotNull { it.toObject(UserData::class.java) }
        } catch (e: Exception) {
            emptyList()
        }
    }
     */
}