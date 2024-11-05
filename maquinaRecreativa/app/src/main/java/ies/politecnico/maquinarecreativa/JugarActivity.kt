package ies.politecnico.maquinarecreativa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ies.politecnico.maquinarecreativa.databinding.ActivityJugarBinding

class JugarActivity:AppCompatActivity() {
    private lateinit var binding: ActivityJugarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJugarBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}