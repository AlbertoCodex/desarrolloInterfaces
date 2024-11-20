package com.example.sistemaconversion

import android.R
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sistemaconversion.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configuración de los Spinners
        val monedas = arrayOf("Dolar", "Euro", "Yen", "Libra")
        val adapter = ArrayAdapter(this, R.layout.simple_spinner_item, monedas)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerIzquierdaMonedas.adapter = adapter
        binding.spinnerDerechaMonedas.adapter = adapter

        // Establecer valores predeterminados para los Spinners
        binding.spinnerIzquierdaMonedas.setSelection(0)
        binding.spinnerDerechaMonedas.setSelection(1)

        // Configuración del botón para calcular
        binding.botonCalc.setOnClickListener {
            calcularConversion()
        }
    }
    // Recoge valores Spinner y Calcula conversion
    private fun calcularConversion() {
        // Obtener las divisas seleccionadas
        val divisaBase = binding.spinnerIzquierdaMonedas.selectedItem.toString()
        val divisaCotizada = binding.spinnerDerechaMonedas.selectedItem.toString()
        val cantidad = binding.etCantidad.text.toString().toDoubleOrNull()

        // Asegurarse que las divisas son diferentes
        if (divisaBase == divisaCotizada) {
            Toast.makeText(this, "Selecciona dos divisas diferentes", Toast.LENGTH_SHORT).show()
            return
        }
        // Asegurarse que la cantidad es positiva
        if (cantidad == null || cantidad <= 0) {
            Toast.makeText(this, "Cantidad no válida", Toast.LENGTH_SHORT).show()
            return
        }

        // Ejemplo de cálculo con una tasa fija
        val tasaConversion = obtenerTasaConversion(divisaBase, divisaCotizada)
        val resultado = cantidad * tasaConversion // Suponemos un monto fijo de 100 para la demo

        // Mostrar el resultado en la vista
        binding.tvResultado.text = String.format("%.2f", resultado)
    }

    private fun obtenerTasaConversion(divisaBase: String, divisaCotizada: String): Double {
        // Simulamos las tasas de conversión
        return when {
            divisaBase == "Dolar" && divisaCotizada == "Euro" -> 0.85 // Ejemplo: 1 USD = 0.85 EUR
            divisaBase == "Euro" && divisaCotizada == "Dolar" -> 1.18 // Ejemplo: 1 EUR = 1.18 USD
            else -> 1.0 // Tasa por defecto (sin conversión)
        }
    }
}