package ies.politecnico.maquinarecreativa

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ies.politecnico.maquinarecreativa.databinding.ActivityAyudaBinding

class AyudaActivity : AppCompatActivity() {
    private lateinit var binding:ActivityAyudaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAyudaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // BOTTOM NAVIGATION BAR
        // Botones
        // Center Home
        binding.btnNavHome?.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent) // Inicia AyudaActivity
        }
        // Izquierda Settings
        binding.btnNavSettings?.setOnClickListener {
            val intent = Intent(this, ConfiguracionActivity::class.java)
            startActivity(intent) // Inicia ConfiguracionActivity
        }
        // Derecha Salir
        binding.btnNavExit?.setOnClickListener {
            finishAffinity() // Cierra la aplicacion
        }
    }
}