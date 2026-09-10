package com.example.lab04_melany

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFE1F5FE)
                ) {
                    MovieCounter()
                }
            }
        }
    }
}

@Composable
fun MovieCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    var movieName by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Creado por: Melany",
            style = MaterialTheme.typography.titleMedium,
            color = Color(0xFF01579B)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "You have added $count movies.",
            style = MaterialTheme.typography.headlineSmall,
            color = Color(0xFF0277BD)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = movieName,
            onValueChange = { movieName = it },
            label = { Text("Movie Name") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF0277BD),
                unfocusedBorderColor = Color(0xFF4FC3F7),
                focusedLabelColor = Color(0xFF0277BD)
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (movieName.isNotBlank()) {
                    count++
                    movieName = ""
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF4FC3F7)
            )
        ) {
            Text(
                text = "Add Movie",
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMovieCounter() {
    MaterialTheme {
        Surface(color = Color(0xFFE1F5FE)) {
            MovieCounter()
        }
    }
}
