package ies.politecnico.examenmcdonalds

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ies.politecnico.examenmcdonalds.databinding.ActivityPolloBinding

class PolloActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPolloBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPolloBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}