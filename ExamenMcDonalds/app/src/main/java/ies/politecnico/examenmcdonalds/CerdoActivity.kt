package ies.politecnico.examenmcdonalds

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ies.politecnico.examenmcdonalds.databinding.ActivityCerdoBinding

class CerdoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCerdoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCerdoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}