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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var password by rememberSaveable {
            mutableStateOf("")
        }
        var PaasswordStates by remember{
            mutableStateOf(false)
        }

        val icones=if(PaasswordStates)painterResource(id = R.drawable.passwordvispel)
        else painterResource(id = R.drawable.passworddisaple)

        OutlinedTextField(value = password, onValueChange = {
            password = it
        },
            placeholder = { Text(text = "Password") },
            label = { Text("Password") },
            trailingIcon = {
                IconButton(onClick = { PaasswordStates=!PaasswordStates}) {
                    Icon(
                        painter = icones,
                        contentDescription = "password visible",

                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType =  KeyboardType.NumberPassword
            ),
            visualTransformation = if(PaasswordStates) VisualTransformation.None
        else PasswordVisualTransformation()
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