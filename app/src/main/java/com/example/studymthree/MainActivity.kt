package com.example.studymthree


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.studymthree.ui.theme.StudymthreeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudymthreeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun ColumnScope.CoustemItem(weightValue:Float,color: Color) {
    Surface(
        modifier = Modifier
            .width(200.dp)
            .height(50.dp)
            .weight(weightValue),
        color =color
    ) {

    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StudymthreeTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.End,

        ) {
            CoustemItem(3f,
                MaterialTheme.colorScheme.secondary)
            Surface(
                modifier = Modifier
                    .width(200.dp)
                    .height(50.dp)
                    .weight(1f),
                color = MaterialTheme.colorScheme.primary
            ) {

            }
            Surface(
                modifier = Modifier
                    .width(200.dp)
                    .height(50.dp)
                    .weight(1f),
                color = MaterialTheme.colorScheme.secondaryContainer
            ) {

            }
        }

    }
}