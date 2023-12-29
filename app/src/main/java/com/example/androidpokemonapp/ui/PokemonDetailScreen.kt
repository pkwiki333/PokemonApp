package com.example.androidpokemonapp.ui

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidpokemonapp.viewModel.PokedexViewModel
import com.example.androidpokemonapp.viewModel.PokemonApiState
import com.example.androidpokemonapp.viewModel.PokemonState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun pokemonDetailScreen(
    name: String,
    padding: PaddingValues,
    pokedexViewModel: PokedexViewModel = viewModel(factory = PokedexViewModel.Factory)
) {
    val pokemonState by pokedexViewModel.pokemonState.collectAsState()
    val pokemonApiState = pokedexViewModel.pokemonApiState

    LaunchedEffect(name) {
        pokedexViewModel.getPokemonDetail(name)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        when (pokemonApiState) {
            is PokemonApiState.Loading -> {
                Log.i("PokemonDetailScreen", "!!!!!!!!!loading")
                CircularProgressIndicator()
            }

            is PokemonApiState.Error -> Text("Couldn't load...")
            is PokemonApiState.Success -> {
                Log.i("PokemonDetailScreen", "!!!!!!!!!succes")
                pokemonDetailScreenContent(
                    padding = padding,
                    pokemonState = pokemonState
                )
            }
        }
    }

}

@Composable
fun pokemonDetailScreenContent(padding: PaddingValues, pokemonState: PokemonState) {
    Card(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Naam: ${pokemonState.pokemonDetail?.name}",
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Pokédex index: ${pokemonState.pokemonDetail?.pokedexIndex}")
            Spacer(modifier = Modifier.height(8.dp))
            Text("Beschrijving: __________", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Type: ${pokemonState.pokemonDetail?.types}")
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}