package com.example.androidpokemonapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import com.example.androidpokemonapp.R
import com.example.androidpokemonapp.model.Pokemon

/**
 * Toont een kaart met gedetailleerde informatie over een willekeurige Pokémon.
 * De inhoud bestaat uit de naam, Pokédex-index, types, abilities,
 * hoogte, gewicht, en de lijst met moves van de Pokémon.
 *
 * De kaart kan verticaal gescrold worden als de content langer is dan het scherm.
 *
 * @param pokemon De Pokémon entiteit met de gegevens die getoond moeten worden.
 */
@Composable
fun RandomPokemonCardInhoud(
    pokemon: Pokemon,
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding_medium))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium))
                .verticalScroll(
                    rememberScrollState()
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Text(
                    "Naam: ",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                )
                Text(
                    pokemon.name,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.testTag("PokemonName")
                )

                Text(
                    "Pokedex:",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_small))
                )
                Text(
                    pokemon.pokedexIndex.toString(),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.testTag("PokemonPokedexIndex")
                )
            }
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
            Row {
                Text(
                    "Types: ",
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                )
                Text(pokemon.types.joinToString(separator = ", "), modifier = Modifier.testTag("PokemonTypes"))
            }

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
            Row {
                Text(
                    "Abilities:",
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                )
                Text(pokemon.abilities.joinToString(separator = ", "), modifier = Modifier.testTag("PokemonAbilities"))
            }
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
            Row {
                Text(
                    "Height: ",
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                )
                Text(
                    "${pokemon.height / 10}m", modifier = Modifier.testTag("PokemonHeight")
                )
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
                Text(
                    "Weight: ",
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_small))
                )
                Text(
                    "${pokemon.weight / 10}kg", modifier = Modifier.testTag("PokemonWeight")
                )
            }

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
            Row {
                Text(
                    "Moves: ",
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                )
                Text(pokemon.moves.joinToString(separator = ", "), modifier = Modifier.testTag("PokemonMoves"))
            }

        }
    }
}
