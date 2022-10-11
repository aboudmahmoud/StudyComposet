package com.example.studymthree


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.TextField
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
import androidx.compose.ui.graphics.Color
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
import com.example.studymthree.CanverCoustem.CoustemCompent


import com.example.studymthree.ui.theme.StudymthreeTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudymthreeTheme {
Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
    var value by remember {
        mutableStateOf(0)

    }
    CoustemCompent(indicatuerValue = value)
    TextField(value = value.toString(), onValueChange ={
        value =  if(it.isNotEmpty()){
            it.toInt()
        }else{
            0
        }

    }, keyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Decimal
    ) ,)
}

            }
        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MyComposable() {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            var name by remember{
                mutableStateOf("")
            }
            val maxChar=10

            OutlinedTextField(
                value =name,
                onValueChange ={if(maxChar>=it.length){
                    name = it
                } },
                label = {Text("name")},
                placeholder = {Text("put ur name")},
                maxLines = 1,
            )
        }
    }


    @Composable
    fun Greeting() {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {


        }
    }


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        StudymthreeTheme {
            Greeting()

        }
    }
}