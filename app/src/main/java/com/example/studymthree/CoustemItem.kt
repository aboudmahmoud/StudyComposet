package com.example.studymthree

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.studymthree.Moudel.Person
import com.example.studymthree.ui.theme.Typography1


@Composable
fun CoustemItem(person: Person) {
    Row (
        modifier = Modifier.background(Color.LightGray)
            .fillMaxWidth()
            .padding(24.dp),
verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
            )
    {
        Text(
            text = "${person.age}",
            color = Color.Black,
            fontSize = Typography1.bodyMedium.fontSize,
            fontWeight = FontWeight.Bold

        )
        Text(
            text = "${person.frsitName}",
            color = Color.Black,
            fontSize = Typography1.bodySmall.fontSize,
            fontWeight = FontWeight.Bold

        )
        Text(
            text = "${person.lasName}",
            color = Color.Black,
            fontSize = Typography1.bodySmall.fontSize,
            fontWeight = FontWeight.Bold

        )

    }
}

@Preview
@Composable
fun PrveiwCousemItem(){
    CoustemItem(Person(1,"aboud","mahmoud",30))
}