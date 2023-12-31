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
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaPrincipal()
        }
    }
}

@Composable
fun PantallaPrincipal() {
    val contexto = LocalContext.current as ComponentActivity

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "¿Cuál es tu Contrato?",
            modifier = Modifier.padding(20.dp)
        )
        Button(
            onClick = {
                val intent = Intent(contexto, HonorariosActivity::class.java)
                contexto.startActivity(intent)
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Honorarios")
        }

        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                val intent = Intent(contexto, PlantaActivity::class.java)
                contexto.startActivity(intent)
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Planta")
        }
    }
}
