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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
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
    ColumnTexts()
}

@Composable
fun ColumnTexts() {
    Column() {
        SuperScripetText("1","2")
        SubScripetText("2","1")
    }
}
@Composable
fun SuperScripetText(
    normalText: String,
    superText: String,
) {
    Text(buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontSize = MaterialTheme.typography.labelMedium.fontSize
            )
        ) {
            append(normalText)
        }

        withStyle( style = SpanStyle(
            fontSize = MaterialTheme.typography.labelSmall.fontSize,
            fontWeight = FontWeight.Normal,
            baselineShift = BaselineShift.Superscript
        )
        ){
            append(superText)
        }
    })
}
@Composable
fun SubScripetText(
    normalText: String,
    SubText: String,
) {
    Text(buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontSize = MaterialTheme.typography.labelMedium.fontSize
            )
        ) {
            append(normalText)
        }

        withStyle( style = SpanStyle(
            fontSize = MaterialTheme.typography.labelSmall.fontSize,
            fontWeight = FontWeight.Normal,
            baselineShift = BaselineShift.Subscript
        )
        ){
            append(SubText)
        }
    })
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StudymthreeTheme {
        Greeting()

    }
}