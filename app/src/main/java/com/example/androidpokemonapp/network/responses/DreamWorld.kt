package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die de Dream World-stijl weergaven van een Pokémon voorstelt.
 *
 * Deze klasse bevat de visuele representaties van Pokémon zoals ze verschijnen in de Dream World,
 * een onderdeel van de Pokémon-games waarin spelers unieke activiteiten kunnen uitvoeren.
 *
 * @property frontDefault De standaard voorkant weergave van de Pokémon in Dream World-stijl.
 * @property frontFemale De vrouwelijke variant van de voorkant weergave in Dream World-stijl, indien aanwezig.
 */
data class DreamWorld(
    val frontDefault: String,
    val frontFemale: Any
)