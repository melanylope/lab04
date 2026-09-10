package com.example.lab04_melany

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

// Paleta de colores Café y Beige elegante
val BeigeFondo = Color(0xFFFDFBF7)
val BeigeClaroCard = Color(0xFFF5EBE6)
val CafePrincipal = Color(0xFF5C4033)
val CafeClaroBoton = Color(0xFF8B5A2B)
val MarronTexto = Color(0xFF3E2723)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = BeigeFondo
                ) {
                    BebidasSecretasApp()
                }
            }
        }
    }
}

@Composable
fun BebidasSecretasApp(modifier: Modifier = Modifier) {
    // Uso correcto de rememberSaveable para persistir el texto al rotar la pantalla
    var bebidaTexto by rememberSaveable { mutableStateOf("") }

    // Lista dinámica reactiva para guardar las bebidas
    val drinkList = remember { mutableStateListOf<String>() }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Recetas de Bebidas Secretas",
            style = MaterialTheme.typography.titleLarge,
            color = CafePrincipal
        )

        Text(
            text = "Barista: Melany",
            style = MaterialTheme.typography.bodyMedium,
            color = CafeClaroBoton
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = bebidaTexto,
            onValueChange = { bebidaTexto = it },
            label = { Text("Nombre de la bebida secreta", color = CafePrincipal) },
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = CafePrincipal,
                unfocusedBorderColor = CafeClaroBoton,
                focusedLabelColor = CafePrincipal,
                cursorColor = CafePrincipal
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                if (bebidaTexto.isNotBlank()) {
                    drinkList.add(bebidaTexto)
                    bebidaTexto = ""
                }
            },
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = CafeClaroBoton
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(
                text = "Guardar Receta Secreta",
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Total registradas: ${drinkList.size}",
            style = MaterialTheme.typography.bodyLarge,
            color = MarronTexto
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(drinkList) { drink ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = BeigeClaroCard),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "• $drink",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MarronTexto
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBebidasSecretas() {
    MaterialTheme {
        Surface(color = BeigeFondo) {
            BebidasSecretasApp()
        }
    }
}

