package edu.itesm.pokedex.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.itesm.pokedex.model.Pokemon
import edu.itesm.pokedex.model.PokemonResponse
import edu.itesm.pokedex.model.PokemonResult
import edu.itesm.pokedex.service.PokemonService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonViewModel() : ViewModel() {
    // llamo al servicio con retorfit
    //MutableLiveData, crea.
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service: PokemonService = retrofit.create(PokemonService::class.java)

    val pokemon = MutableLiveData<Pokemon>()

    fun getPokemon(id: Int) {
        val call = service.getUnPokemon(id)
        call.enqueue(object : Callback<Pokemon> {
            override fun onResponse(
                call: Call<Pokemon>,
                response: Response<Pokemon>
            ) {
                response.body()?.let { pika ->
                    pokemon.postValue(pika)
                }

            }

            override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                call.cancel()
            }

        })
    }

}