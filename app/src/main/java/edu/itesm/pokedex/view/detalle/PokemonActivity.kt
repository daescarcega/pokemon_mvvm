package edu.itesm.pokedex.view.detalle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import edu.itesm.pokedex.databinding.ActivityMainBinding
import edu.itesm.pokedex.viewmodel.PokemonViewModel

class PokemonActivity : AppCompatActivity() {

    lateinit var viewModel: PokemonViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(PokemonViewModel::class.java)

        initUI()
    }

    private fun initUI(){
        val id = intent.extras?.get("id") as Int


    }
}