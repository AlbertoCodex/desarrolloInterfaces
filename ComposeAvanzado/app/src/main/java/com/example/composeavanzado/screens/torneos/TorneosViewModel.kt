package com.example.composeavanzado.screens.torneos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.composeavanzado.data.TorneoData
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

class TorneosViewModel: ViewModel() {
    private val _torneos = MutableLiveData<List<TorneoData>>()
    val torneos: LiveData<List<TorneoData>> = _torneos

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun cargarTorneosConFiltros(
        db: FirebaseFirestore,
        modalidad: String? = null,
        pais: String? = null
    ) {
        _isLoading.value = true
        var query: Query = db.collection("torneos")

        // Aplica filtros solo si no son nulos
        if (!modalidad.isNullOrEmpty()) {
            query = query.whereEqualTo("modalidad", modalidad)
        }
        if (!pais.isNullOrEmpty()) {
            val banderaUrl = getBanderaResource(pais)
            query = query.whereEqualTo("pais", banderaUrl)
        }

        query.get()
            .addOnSuccessListener { snapshot ->
                val listaTorneos = snapshot.documents.map { doc ->
                    TorneoData(
                        numero = doc.getLong("numero")?.toInt() ?: 0,
                        nombre = doc.getString("nombre") ?: "",
                        modalidad = doc.getString("modalidad") ?: "",
                        numJugadores = doc.getLong("numJugadores")?.toInt() ?: 0,
                        pais = doc.getString("pais") ?: "bandera_default"
                    )
                }
                _torneos.value = listaTorneos
                _isLoading.value = false
            }
            .addOnFailureListener { error ->
                println("Error al cargar los torneos con filtros: ${error.message}")
                _isLoading.value = false
            }
    }

    // Función auxiliar para mapear el nombre del pais con la bandera
    private fun getBanderaResource(pais: String): String {
        return when (pais) {
            "España" -> "https://firebasestorage.googleapis.com/v0/b/pokerapp-3ca75.firebasestorage.app/o/banderas%2Fbandera_es.jpg?alt=media&token=1dae305d-347a-47c6-97ac-1f50293d0070"
            "Francia" -> "https://firebasestorage.googleapis.com/v0/b/pokerapp-3ca75.firebasestorage.app/o/banderas%2Fbandera_fr.png?alt=media&token=9f7d686e-c8ef-4918-8025-a4040bbdfde3"
            "Alemania" -> "https://firebasestorage.googleapis.com/v0/b/pokerapp-3ca75.firebasestorage.app/o/banderas%2Fbandera_ger.png?alt=media&token=8bca2cb8-d474-48ca-9c20-a2ee41d0333c"
            else -> "bandera_default"
        }
    }
}