package ies.politecnico.maquinarecreativa

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
    }
}