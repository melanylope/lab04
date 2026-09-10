package com.example.lab04_melany

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ContenidoLaboratorio()
                }
            }
        }
    }
}

@Composable
fun ContenidoLaboratorio() {
    var textoEstado by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // COMPONENTE 1: Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Laboratorio 04 - Melany",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "Componente Card agregado correctamente.",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        // COMPONENTE 2 MODIFICADO: OutlinedTextField con estilo actualizado
        OutlinedTextField(
            value = textoEstado,
            onValueChange = { textoEstado = it },
            label = { Text("Escribe tu apellido aquí") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = MaterialTheme.colorScheme.secondary
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}


