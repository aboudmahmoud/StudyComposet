package com.example.studymthree


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studymthree.ui.theme.StudymthreeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudymthreeTheme {
                // A surface container using the 'background' color from the theme
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        Box(
            modifier = Modifier
                .background(Color.Blue)
                .width(100.dp)
                .height(100.dp)
                .verticalScroll(rememberScrollState())
        ) {
Text(text = "We Love The King Aboud", fontSize = 40.sp)
        }
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StudymthreeTheme {
        Greeting()

    }
}