package edu.itesm.pokedex.view.lista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import edu.itesm.pokedex.databinding.ActivityMainBinding
import edu.itesm.pokedex.databinding.ActivityPokedexBinding
import edu.itesm.pokedex.view.detalle.PokemonActivity
import edu.itesm.pokedex.viewmodel.PokedexViewModel

class PokedexActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPokedexBinding
    private lateinit var viewModel: PokedexViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPokedexBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(PokedexViewModel::class.java)

        creaUI()
    }

    private fun creaUI() {

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.recyclerView.adapter = PokedexAdapter{
            val intent = Intent(this, PokemonActivity::class.java)
            intent.putExtra("id", it)
            startActivity(intent)
        }


    }

}