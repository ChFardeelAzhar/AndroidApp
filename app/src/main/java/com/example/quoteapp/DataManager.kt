package com.example.quoteapp

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.google.gson.Gson

object DataManager {

    var data = emptyArray<Model>()

    var currentQuote : Model? = null

    var isDataLoaded = mutableStateOf(false)
    var currentPage = mutableStateOf(Pages.ListingScreen)

    fun loadAssetFromFile(context: Context){

        val inputStream = context.assets.open("quote.json")
        val size : Int = inputStream.available()
        val buffer = ByteArray(size)

        inputStream.read(buffer)
        inputStream.close()

        val json = String(buffer,Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Model>::class.java)
        isDataLoaded.value =  true
    }

    fun switchPage (quote: Model ? ){
        if (currentPage.value == Pages.ListingScreen){
            currentQuote = quote
            currentPage.value = Pages.DetailScreen

        }
        else {
            currentPage.value = Pages.ListingScreen
        }
    }

}