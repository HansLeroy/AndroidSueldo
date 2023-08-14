package com.example.sueldoliquido

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class PlantaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planta)

        val btnVolver = findViewById<Button>(R.id.btnVolver)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val textValor = findViewById<EditText>(R.id.textValor)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        btnCalcular.setOnClickListener {
            val sueldoBruto = textValor.text.toString().toDoubleOrNull()

            if (sueldoBruto != null) {
                val planta = Planta()
                val sueldoLiquido = planta.calcularLiquido(sueldoBruto)
                tvResultado.text = "Sueldo Líquido: $sueldoLiquido"
            } else {
                tvResultado.text = "Ingresa un valor válido"
            }
        }

        btnVolver.setOnClickListener {
            finish()
        }
    }
}