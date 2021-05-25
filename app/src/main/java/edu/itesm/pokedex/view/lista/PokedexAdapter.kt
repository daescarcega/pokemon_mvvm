package edu.itesm.pokedex.view.lista

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.itesm.pokedex.R
import edu.itesm.pokedex.databinding.ActivityMainBinding
import edu.itesm.pokedex.databinding.PokemonRenglonBinding
import edu.itesm.pokedex.model.PokeResult

class PokedexAdapter(val pokemonClick: (Int) -> Unit): RecyclerView.Adapter<PokedexAdapter.PokemonViewHolder>() {
    var pokemonList: List<PokeResult> = emptyList<PokeResult>()

    fun setData(list: List<PokeResult>){
        pokemonList = list
        notifyDataSetChanged()
    }
    inner class PokemonViewHolder(val binding: PokemonRenglonBinding): RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding = PokemonRenglonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonViewHolder(binding)
    }

    override fun getItemCount() = pokemonList.size


    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = pokemonList[position]

        holder.binding.pokemonTextView.text = "#${position + 1} - ${pokemon.name}"

        holder.itemView.setOnClickListener { pokemonClick(position + 1) }
    }

}