package com.example.androidpokemonapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androidpokemonapp.ui.PokemonScreen
import com.example.androidpokemonapp.ui.ScreensEnum
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.androidpokemonapp.ui.PokedexScreen
import com.example.androidpokemonapp.ui.PokemonOfTheDayScreen
import com.example.androidpokemonapp.ui.pokemonDetailScreen
import com.example.androidpokemonapp.ui.YourTeamScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonApp(
    navController: NavHostController = rememberNavController(),
) {
    var addingVisible by remember { mutableStateOf(false) }
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen =
        ScreensEnum.valueOf(backStackEntry?.destination?.route ?: ScreensEnum.PokemonScreen.name)

    Box(modifier = Modifier.fillMaxSize()) {

        Scaffold(
            /*topBar = {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center, // Centreer de inhoud horizontaal
                verticalAlignment = Alignment.CenterVertically // Centreer de inhoud verticaal
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pokemon_23),
                    contentDescription = "Pokémon logo",
                    modifier = Modifier.size(200.dp)
                )
            }
        }, */
            content = { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = ScreensEnum.PokemonScreen.name
            ) {
                composable(ScreensEnum.PokemonScreen.name) {
                    PokemonScreen(
                        innerPadding,
                        onPokemonOfTheDayClicked = { navController.navigate(ScreensEnum.PokemonOfTheDayScreen.name) },
                        onPokedexClicked = { navController.navigate(ScreensEnum.PokedexScreen.name) },
                        onYourTeamClicked = { navController.navigate(ScreensEnum.YourTeamScreen.name) },
                    )
                }
                composable(ScreensEnum.PokemonOfTheDayScreen.name) {
                    //todo als dit werkt goed anders in cupcake staat dit anders
                    PokemonOfTheDayScreen(onBackButtonClicked = { navController.navigateUp() })
                }
                composable(ScreensEnum.PokedexScreen.name) {
                    PokedexScreen(onBackButtonClicked = { navController.navigateUp() }, onPokemonClicked = { navController.navigate(ScreensEnum.PokemonDetailScreen.name) },)
                }
                composable(ScreensEnum.YourTeamScreen.name) {
                    YourTeamScreen(onBackButtonClicked = { navController.navigateUp() }, onPokemonClicked = { navController.navigate(ScreensEnum.PokemonDetailScreen.name) },)
                }
                composable(ScreensEnum.PokemonDetailScreen.name) {
                    pokemonDetailScreen(onBackButtonClicked = { navController.navigateUp() },)
                }
            }
        })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskAppAppBar(
    currentScreen: ScreensEnum,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),

        title = {
            Image(
                painter = painterResource(id = R.drawable.pokemon_23),
                contentDescription = "Pokémon logo",
                modifier = Modifier.size(200.dp)
            )
        },
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "navigate back"
                    )
                }
            }
        }
    )
}