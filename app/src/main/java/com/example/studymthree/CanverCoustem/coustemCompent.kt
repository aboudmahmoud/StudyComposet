package com.example.studymthree.CanverCoustem



import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment


import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable
fun CoustemCompent(
    canvesSize: Dp = 300.dp,
    indicatuerValue:Int=0,
    maxIndicatorValue:Int=100,
    indicatorStrokeCap:StrokeCap=StrokeCap.Round,
    backGroudindicatorColor: Color=MaterialTheme.colorScheme.onSurface.copy(alpha =0.1f),
    backGroundindicatorStrokeWdith:Float=100f,
    forGroundIndidcatorColor:Color=MaterialTheme.colorScheme.primary,
    forGroundIndicatorStrokeWdith:Float=100f,
    bigTextFontntsize:TextUnit =MaterialTheme.typography.bodyLarge.fontSize,
    bigTextColor: Color=MaterialTheme.colorScheme.onSurface,
    bigTextSufixs:String="GB",
    smellText:String="Reamaing",
    smallTextFontSize: TextUnit= MaterialTheme.typography.labelLarge.fontSize,
    smalTextColor:Color=MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f)
    ) {
    var allowIndctetorNumber by remember {
        mutableStateOf(maxIndicatorValue)
    }
    allowIndctetorNumber= if(indicatuerValue<=maxIndicatorValue){
        indicatuerValue
    }else{
        maxIndicatorValue
    }
    var animateIndcatorValu by remember{
        mutableStateOf(0f)
    }
    LaunchedEffect(key1 =  allowIndctetorNumber){
        animateIndcatorValu=(allowIndctetorNumber.toFloat())
    }
    val precatnge =(animateIndcatorValu/maxIndicatorValue)*100

    val swaepaAngel
    by animateFloatAsState(targetValue = (2.4 * precatnge).toFloat(),
    animationSpec = tween(1000)
    )

    val recviedvalue by animateIntAsState(
        targetValue = allowIndctetorNumber,
    animationSpec = tween(1000)
    )
    val animtedTextColor by animateColorAsState(
        targetValue = if (allowIndctetorNumber == 0) MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f)
    else
        bigTextColor, animationSpec = tween(1000)
    )
    Column(modifier = Modifier
        .size(canvesSize)
        .drawBehind {
            val componetSize = size / 1.25f
            backGroundIndecator(
                componetSize = componetSize,
                indicatroColor = backGroudindicatorColor,
                indicaotorStrokeWidth = backGroundindicatorStrokeWdith,
                indicatorStrokeCap = indicatorStrokeCap
            )
            forGroundIndecator(
                sawepAngle = swaepaAngel,
                componetSize = componetSize,
                indicaotorStrokeWidth = forGroundIndicatorStrokeWdith,
                indicatroColor = forGroundIndidcatorColor,
                indicatorStrokeCap = indicatorStrokeCap
            )
        }, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        EmededElements(
            bigText =recviedvalue ,
            bigTextFontntsize =bigTextFontntsize ,
            bigTextColor =animtedTextColor ,
            bigTextSufixs =bigTextSufixs ,
            smellText =smellText ,
            smalTextColor = smalTextColor,
            smallTextFontSize =smallTextFontSize
        )
    }

}

@Composable
fun EmededElements(
    bigText:Int,
    bigTextFontntsize:TextUnit,
    bigTextColor: Color,
    bigTextSufixs:String,
    smellText:String,
    smalTextColor:Color,
    smallTextFontSize:TextUnit
) {
    Text(
        text = smellText,
        color = smalTextColor,
        fontSize = smallTextFontSize,
        textAlign = TextAlign.Center
    )
    Text(
        text = "${bigText} ${bigTextSufixs.take(2)}",
        color = bigTextColor,
        fontSize = bigTextFontntsize,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold
    )

}

fun DrawScope.backGroundIndecator(
    componetSize: Size,
    indicatroColor: Color,
    indicaotorStrokeWidth:Float,
    indicatorStrokeCap:StrokeCap
    ) {
    drawArc(
        size= componetSize,
        color = indicatroColor,
        startAngle = 150f,
        sweepAngle = 240f,
        useCenter = false,
        style = Stroke(
            width = indicaotorStrokeWidth,
            cap = indicatorStrokeCap
        ),
        topLeft = Offset(
            x=(size.width-componetSize.width)/2f,
            y=(size.height-componetSize.height)/2f
        )

    )

}

fun DrawScope.forGroundIndecator(
    sawepAngle:Float,
    componetSize: Size,
    indicatroColor: Color,
    indicaotorStrokeWidth:Float,
    indicatorStrokeCap:StrokeCap,
    ) {
    drawArc(
        size= componetSize,
        color = indicatroColor,
        startAngle = 150f,
        sweepAngle = sawepAngle,
        useCenter = false,
        style = Stroke(
            width = indicaotorStrokeWidth,
            cap = indicatorStrokeCap
        ),
        topLeft = Offset(
            x=(size.width-componetSize.width)/2f,
            y=(size.height-componetSize.height)/2f
        )

    )

}
@Preview(showBackground = true)
@Composable
fun PrviewCoustemCompmnet() {
    CoustemCompent()
}