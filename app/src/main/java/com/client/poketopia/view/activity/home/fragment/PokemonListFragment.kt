package com.client.poketopia.view.activity.home.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.client.poketopia.R
import com.client.poketopia.databinding.FragmentPokemonListBinding
import com.client.poketopia.view.activity.home.HomeCommunicator

class PokemonListFragment : Fragment() {
    private var _binding: FragmentPokemonListBinding?= null
    private val binding get() = _binding!!
    private var input = ""
    private lateinit var homeCommunicator: HomeCommunicator

    companion object{
        fun newInstance(input: String): PokemonListFragment{
            val fragment = PokemonListFragment()
            fragment.input = input

            val bundle = Bundle()
            bundle.putString(DELIVERED_INPUT, input)
            fragment.arguments = bundle
            return fragment
        }

        const val DELIVERED_INPUT = "DELIVERED_INPUT"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonListBinding.inflate(layoutInflater, container, false)
        initView()
        homeCommunicator = activity as HomeCommunicator
        return binding.root
    }

    private fun initView(){
        binding.tvTitle.text = String.format(getString(R.string.dummytxt_fragment), input)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}