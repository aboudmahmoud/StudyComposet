package com.example.studymthree


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
    SelectionContainer() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = stringResource(R.string.android),
            modifier = Modifier
                .background(Color.Green)
                .padding(16.dp)
                .width(200.dp)
                .background(Color.Red),
            color = Color.White,
            fontSize = MaterialTheme.typography.headlineMedium.fontSize,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.End
        )

            Text(
                text = stringResource(R.string.android),

                )
            DisableSelection {
                Text(
                    text = stringResource(R.string.android),

                    )
            }

            Text(
                text = stringResource(R.string.android),

                )
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