package com.example.sueldoliquido

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sueldoliquido.ui.theme.SueldoLiquidoTheme

@OptIn(ExperimentalMaterial3Api::class)
class HonorariosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaHonorario()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaHonorario() {
    var sueldoBruto by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }
    val contexto = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            placeholder = { Text("Sueldo Bruto") },
            value = sueldoBruto,
            onValueChange = { sueldoBruto = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                val sueldoBrutoDouble = sueldoBruto.toDoubleOrNull() ?: 0.0
                val empleado = Honorario()
                val sueldoLiquido = empleado.calcularLiquido(sueldoBrutoDouble)
                resultado = "Sueldo líquido: $sueldoLiquido"
            }
        ) {
            Text("Calcular Sueldo")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = resultado)

        Button(onClick = {
            val intent = Intent(contexto, MainActivity::class.java)
            contexto.startActivity(intent)
        }) {
            Text("Volver")
        }
    }
}