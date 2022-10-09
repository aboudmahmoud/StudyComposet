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
import com.example.studymthree.Resportroy.Resportory

import com.example.studymthree.ui.theme.StudymthreeTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudymthreeTheme {
                //frist and Scend
                val resportory = Resportory()
                val getAllData = resportory.getALlPessonsData()

                //Thrid

                val sections = listOf(
                    "A","B","C","D","E","F","G"
                )
                LazyColumn(
                    contentPadding = PaddingValues(all=12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    //Frsist Way
                  /*  items(items = getAllData) {
                        CoustemItem(person = it)
                    }*/

                    //Scend way
                  /*  itemsIndexed(items = getAllData,
                    ) {
                            index,it ->
                        Log.d("Aboud", "onCreate: ${index} ")
                        CoustemItem(person = it)
                    }*/
                    //thrid way
                    sections.forEach{
                        section->
                        stickyHeader {
                            Text(  modifier = Modifier.fillMaxWidth()
                                .background(Color.LightGray)
                                .padding(12.dp),text = "Section ${section}"
                            )
                        }
                        items(10){
                            Text(
                                modifier = Modifier.padding(12.dp),
                            text="Item $it from the section ${section}"
                            )
                        }
                    }
                }
            }
        }
    }


    @Composable
    fun Greeting() {

    }


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        StudymthreeTheme {
            Greeting()

        }
    }
}