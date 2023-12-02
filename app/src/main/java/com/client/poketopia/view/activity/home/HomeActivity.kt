package com.client.poketopia.view.activity.home

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.client.poketopia.databinding.ActivityHomeBinding
import com.client.poketopia.view.activity.home.fragment.AboutFragment
import com.client.poketopia.view.activity.home.fragment.MyPokemonListFragment
import com.client.poketopia.view.activity.home.fragment.PokemonListFragment

class HomeActivity : AppCompatActivity(), HomeCommunicator {
    private lateinit var binding: ActivityHomeBinding
    private val TAG = HomeActivity::class.java.simpleName

    private lateinit var adapterFragmentHome: AdapterFragmentHome

    companion object{
        fun newIntent(context: Context): Intent = Intent(context, HomeActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpView()
    }

    private fun setUpView(){
        adapterFragmentHome = AdapterFragmentHome(
            supportFragmentManager,
            lifecycle
        )

        val myPokemonListFragment = MyPokemonListFragment.newInstance("My Pokemon List")
        val pokemonListFragment = PokemonListFragment.newInstance("List Pokemon")
        val aboutFragment = AboutFragment.newInstance("About")

        val listFragment = listOf<Fragment>(myPokemonListFragment, pokemonListFragment, aboutFragment)
        adapterFragmentHome.fragmentList.addAll(listFragment)

        binding.vpFragment.apply {
            offscreenPageLimit = listFragment.size
            adapter = adapterFragmentHome
            currentItem = 0
        }
    }
}