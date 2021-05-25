package edu.itesm.pokedex.view.lista

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.itesm.pokedex.databinding.PokemonRenglonBinding
import edu.itesm.pokedex.model.PokemonResult

class PokedexAdapter(val pokemonClick: (Int) -> Unit): RecyclerView.Adapter<PokedexAdapter.PokemonViewHolder>() {
    var pokemonList: List<PokemonResult> = emptyList<PokemonResult>()

    fun setData(list: List<PokemonResult>){
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