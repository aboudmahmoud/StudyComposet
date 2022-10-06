package com.example.studymthree

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.studymthree.ui.theme.cornerShapes
import com.example.studymthree.ui.theme.shapes


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GoogleButton(
    textButton: String = "sign up with google",
    lodaingText: String = "Loading....",
    icon: Painter = painterResource(id = R.drawable.googlebutton),
    shape: Shape =cornerShapes,
    bordercolor:Color= Color.LightGray,
    borderWidth: Dp = 1.dp,
    backgroundColor:Color=MaterialTheme.colors.surface,
    progessColorIndicotr:Color=MaterialTheme.colors.primary

) {
    var clicked by remember {
        mutableStateOf(false)
    }
    Surface(
        onClick = {
            clicked = !clicked
        },
        shape = shape,
        border = BorderStroke(width = borderWidth, color =bordercolor),
        color = backgroundColor
    ) {
        Row(
            modifier = Modifier
                .height(40.dp)
                .padding(start = 16.dp, end = 24.dp)
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            verticalAlignment = Alignment.CenterVertically

        ) {
            Icon(
                modifier = Modifier.padding(end = 8.dp),
                painter = icon,
                contentDescription = "google button",
                tint = Color.Unspecified
            )
            Text(
                text = if (clicked) {
                    lodaingText
                } else textButton
            )
            if (clicked) {
                Spacer(modifier = Modifier.width(8.dp))
                CircularProgressIndicator(
                    modifier = Modifier
                        .height(16.dp)
                        .width(16.dp), strokeWidth = 2.dp,
                    color = progessColorIndicotr
                )
            }
        }
    }
}

@Preview
@Composable
fun GoogleButtonPrwvie() {
    GoogleButton()
}