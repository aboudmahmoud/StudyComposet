package com.example.studymthree

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ContentAlpha
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.studymthree.ui.theme.shapes
var Body= "من كانتِ الآخرةُ هَمَّهُ جعلَ اللَّهُ غناهُ في قلبِهِ وجمعَ لَه شملَهُ وأتتهُ الدُّنيا وَهيَ راغمة، ومن كانتِ الدُّنيا همَّهُ جعلَ اللَّهُ " +
"فقرَهُ بينَ عينيهِ وفرَّقَ عليهِ شملَهُ، ولم يأتِهِ منَ الدُّنيا إلَّا ما قُدِّرَ لَهُ\n";

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExtandCostemcard(
    title:String= "الله اكبر",
    descrecpation:String= Body,
    titelWeight:FontWeight=FontWeight.Bold,
    titelsize:TextUnit=MaterialTheme.typography.headlineLarge.fontSize,
    descrecpationsize:TextUnit=MaterialTheme.typography.labelMedium.fontSize,

    ) {
    var ExtandState by remember {
        mutableStateOf(false)
    }
    val rotationstate by animateFloatAsState(targetValue = if (ExtandState) 180f else 0f)
    Card(
        onClick = {
            ExtandState = !ExtandState
        },
        Modifier.padding(15.dp)
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing =LinearOutSlowInEasing,
                )
            )
            .background(Color.White),
        shape = shapes.medium,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text =title,
                    Modifier.weight(6f),
                    fontWeight =titelWeight,
                    fontSize = titelsize,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                IconButton(
                    modifier = Modifier
                        .alpha(ContentAlpha.medium)
                        .weight(1f)
                        .rotate(rotationstate),
                    onClick = { ExtandState = !ExtandState }) {
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "")
                }
            }
            if(ExtandState){
                Text(text =descrecpation,
                fontSize =descrecpationsize ,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrievwExtand() {
    ExtandCostemcard()
}