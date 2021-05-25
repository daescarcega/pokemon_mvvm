package edu.itesm.pokedex.model


data class Pokemon (
    val id: Int,
    val name: String,
    val weight: Int,
    val height: Int,
    val sprites: Sprites
)

data class Sprites (
    val front_default: String?,
    val front_shiny: String?
)

data class PokemonResponse (
    val results: List<PokemonResult>
)

data class PokemonResult (
   val name: String,
   val url: String
)