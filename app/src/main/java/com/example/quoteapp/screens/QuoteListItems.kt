package com.example.quoteapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.quoteapp.Model

@Composable
fun QuoteLIstItems (quote : Model, onClick : (quote : Model)-> Unit) {
    Card(
        elevation = 4.dp,
        modifier = Modifier.padding(8.dp)
            .clickable {
                onClick(quote)
            }
    ) {
        Row(modifier = Modifier.padding(16.dp)) {

            Image(

                imageVector = Icons.Filled.FormatQuote,
                contentDescription = null,
                colorFilter = ColorFilter.tint(Color.White),
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.Black)
                    .rotate(180f),
                alignment = Alignment.TopStart
            )

            Spacer(modifier = Modifier.size(10.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = quote.text,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(bottom = 6.dp)
                )

                Spacer(modifier = Modifier.size(4.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth(.4f)
                        .background(Color.Gray)
                        .height(1.dp)

                )

                Text(
                    text = quote.author,
                    style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.Thin,
                    modifier = Modifier.padding(top = 4.dp)
                )

            }
        }


    }

}

