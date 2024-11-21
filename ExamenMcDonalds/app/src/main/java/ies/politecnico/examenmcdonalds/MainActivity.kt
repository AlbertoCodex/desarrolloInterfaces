package ies.politecnico.examenmcdonalds

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ies.politecnico.examenmcdonalds.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Configuracion botones
        binding.btnPollo?.setOnClickListener {
            val polloActivity = Intent(this, PolloActivity::class.java)
            startActivity(polloActivity)
        }
        binding.btnCerdo?.setOnClickListener {
            val cerdoActivity = Intent(this, CerdoActivity::class.java)
            startActivity(cerdoActivity)
        }
        binding.btnTernera?.setOnClickListener {
            val terneraActivity = Intent(this, TerneraActivity::class.java)
            startActivity(terneraActivity)
        }
    }
}