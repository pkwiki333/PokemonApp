package com.example.androidpokemonapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.androidpokemonapp.R
import com.example.androidpokemonapp.viewModel.RandomPokemonUIState
import com.example.androidpokemonapp.viewModel.RandomPokemonViewModel

@Composable
fun RandomPokemonCardInhoud(
    randomPokemonState: RandomPokemonUIState,
    randomPokemonViewModel: RandomPokemonViewModel,
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding_medium))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Naam: ${randomPokemonState.pokemonDetail?.name}",
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))

            Text("Types: ${randomPokemonState.pokemonDetail?.types}")
            Text("Pokédex index: ${randomPokemonState.pokemonDetail?.pokedexIndex}")
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
            Text("Moves")
            Text("________________")
            Text("________________")
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
            Text("Beschrijving")
            Text("________________")
            Text("________________")

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = { randomPokemonViewModel.getRandomPokemon() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.padding_small))
            ) {
                Text(text = stringResource(R.string.get_random_pok_mon))
            }

        }
    }
}