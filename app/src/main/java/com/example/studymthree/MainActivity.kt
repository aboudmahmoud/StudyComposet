package com.example.studymthree


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.*

import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation

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
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CoilImage()
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://gccgamers.com/media/magefan_blog/gaming-pc.jpg")
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.wait),
            error = painterResource(R.drawable.error) ,
            contentDescription = "s",
            contentScale = ContentScale.Crop,
            modifier = Modifier.clip(CircleShape)
        )
    }
}

@Composable
fun CoilImage() {
    Box(
        modifier = Modifier
            .width(150.dp)
            .height(150.dp),
        contentAlignment = Alignment.Center
    ) {
        val painter = rememberAsyncImagePainter(ImageRequest.Builder(LocalContext.current)
            .data("https://gccgamers.com/media/magefan_blog/gaming-pc.jpg").apply(
            {
                placeholder(R.drawable.wait)
                error(R.drawable.error)
                crossfade(1000)
               transformations(
                   CircleCropTransformation(),

               )

            }).build()
        )
        Image(
            painter = painter,
            contentDescription = "logo image",
            modifier = Modifier.fillMaxSize()
        )



    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StudymthreeTheme {
        Greeting()

    }
}