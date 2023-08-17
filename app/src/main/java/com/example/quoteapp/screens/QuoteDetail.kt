package com.example.quoteapp.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.quoteapp.DataManager
import com.example.quoteapp.Model
import com.example.quoteapp.Pages

@Composable
fun DetailScreen(quote : Model, ){

    BackHandler() {
        DataManager.switchPage(null)
    }
    Box(
        modifier = Modifier
            .fillMaxSize(1f)
            //.clickable { DataManager.currentPage.value = Pages.ListingScreen }
            .background(color = Color.LightGray)
            .background(brush = Brush.sweepGradient(colors = listOf(Color.White, Color.LightGray)))
        ,
        contentAlignment = Alignment.Center,
    ) {

        Card(
            elevation = 4.dp,
            modifier =  Modifier
                .fillMaxWidth()
                .padding(32.dp),


            ) {

            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(16.dp, 32.dp)
                    .align(Alignment.Center)
            ) {
                Image(
                    imageVector = Icons.Filled.FormatQuote,
                    contentDescription = "Quote",
                    alignment = Alignment.Center,
                    modifier = Modifier
                        .size(60.dp)
                        .padding(bottom = 8.dp)
                        .rotate(180f)
                )

                Text(
                    text = quote.text,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(bottom = 6.dp)
                )

                Text(
                    text = quote.author,
                    style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.Light
                )
            }

        }

    }

}