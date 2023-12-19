package com.example.androidpokemonapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.w3c.dom.Text


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonOfTheDayScreen() {
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {
                    Text(text = "Pokémon of the day", fontWeight = FontWeight.Bold)
                },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/}){
                        Icon(Icons.Filled.ArrowBack, "Back")
                    }
                }
            )
        },
        content = {padding ->
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp),
            ){
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ){
                    Text("Naam: __________", style = MaterialTheme.typography.titleLarge)
                    Spacer(modifier = Modifier.height(8.dp))
                    // Placeholder for the Pokémon image
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .background(Color.LightGray),
                        contentAlignment = Alignment.Center
                    ){
                        Text("Foto")
                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    Text("Types: __________")
                    Text("Pokédex index: __________")
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Moves")
                    Text("________________")
                    Text("________________")
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Beschrijving")
                    Text("________________")
                    Text("________________")
                }
            }
        }
    )
}