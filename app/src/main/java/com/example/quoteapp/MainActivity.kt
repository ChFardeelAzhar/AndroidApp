package com.example.quoteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.quoteapp.screens.DetailScreen
import com.example.quoteapp.screens.QuoteList
import kotlinx.coroutines.*

class MainActivity : ComponentActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        GlobalScope.launch {
            DataManager.loadAssetFromFile(applicationContext)
        }

        setContent {
            MainScreen()
        }

    }
}

@Composable
fun MainScreen(){
    
    if (DataManager.currentPage.value == Pages.ListingScreen) {
        if (DataManager.isDataLoaded.value) {
            QuoteList(data = DataManager.data, onClick = {
                DataManager.switchPage(it)
            })
        }
    }
    else {
        DataManager.currentQuote?.let { DetailScreen(quote = it) }
    }
    
}



enum class Pages(){
    ListingScreen,
    DetailScreen
}