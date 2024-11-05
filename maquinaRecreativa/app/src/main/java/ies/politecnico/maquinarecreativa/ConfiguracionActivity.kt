package ies.politecnico.maquinarecreativa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ies.politecnico.maquinarecreativa.databinding.ActivityConfiguracionBinding

class ConfiguracionActivity: AppCompatActivity() {
    private lateinit var binding: ActivityConfiguracionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfiguracionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}