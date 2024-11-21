package ies.politecnico.examenmcdonalds

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ies.politecnico.examenmcdonalds.databinding.ActivityTerneraBinding

class TerneraActivity : AppCompatActivity() {
    private lateinit var binding:ActivityTerneraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTerneraBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}