package com.example.androidpokemonapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.example.androidpokemonapp.model.Pokemon
import com.example.androidpokemonapp.model.PokemonList

@Entity
data class DbPokemon(
    @PrimaryKey
    val name: String,
    val pokedexIndex: Int,
    val height: Int,
    val weight: Int,
    val types: List<String>,
    val abilities: List<String>
)

fun Pokemon.asDatabaseObject(): DbPokemon {
    return DbPokemon(
        name = name,
        pokedexIndex = pokedexIndex,
        height = height,
        weight = weight,
        types = types,
        abilities = abilities
    )
}

fun DbPokemon.asDomainObject(): Pokemon {
    return Pokemon(
        name = name,
        pokedexIndex = pokedexIndex,
        height = height,
        weight = weight,
        types = types,
        abilities = abilities
    )
}

fun List<DbPokemon>.asDomainObject(): List<Pokemon> {
    return map {
        it.asDomainObject()
    }
}