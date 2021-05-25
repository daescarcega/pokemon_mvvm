package edu.itesm.pokedex.service

import edu.itesm.pokedex.model.PokemonResponse
import edu.itesm.pokedex.model.Pokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {

    @GET("pokemon/{id}")
    fun getUnPokemon(@Path("id") id: Int): Call<Pokemon>

    @GET("pokemon")
    fun getListaPokemons(@Query("limit") limit: Int, @Query("offset") offset: Int): Call<PokemonResponse>
}