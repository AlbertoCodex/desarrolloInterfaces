package ies.politecnico.maquinarecreativa

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ies.politecnico.maquinarecreativa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Configuracion boton "Ayuda"
        binding.btnHelp.setOnClickListener {
            // Crea un Intent para abrir AyudaActivity
            val intent = Intent(this, AyudaActivity::class.java)
            startActivity(intent) // Inicia AyudaActivity
        }
        // Configuracion boton "Salir"
        binding.btnExit.setOnClickListener {
            finishAffinity() // Cierra la aplicacion
        }
        // Configuracion boton "Configuracion"
        binding.btnSettings.setOnClickListener {
            val intent = Intent(this, ConfiguracionActivity::class.java)
            startActivity(intent) // Inicia ConfiguracionActivity
        }
        // Configuracion boton "Jugar"
        binding.btnSettings.setOnClickListener {
            val intent = Intent(this, JugarActivity::class.java)
            startActivity(intent) // Inicia ConfiguracionActivity
        }
    }
}