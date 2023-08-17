package com.example.quoteapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quoteapp.Model

@Composable
fun QuoteList(data: Array<Model>, onClick: (quote : Model) -> Unit) {

        LazyColumn(horizontalAlignment = CenterHorizontally, content = {

            item {
                Text(
                    text = "Quote App",
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(10.dp,25.dp)

                )
            }


            items(data) {
                QuoteLIstItems(quote = it, onClick)
            }
        })



}
