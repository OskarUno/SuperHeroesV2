package com.awakelab.oskar.superheroesv2.presentacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.awakelab.oskar.superheroesv2.R
import com.awakelab.oskar.superheroesv2.databinding.FragmentListadoHeroeBinding

class ListadoHeroeFragment : Fragment() {
    lateinit var binding: FragmentListadoHeroeBinding
    private val heroeVM: HeroeViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentListadoHeroeBinding.inflate(layoutInflater, container, false)
        initAdapter()
        heroeVM.getAllHereoesVM()
        return binding.root
    }

    private fun initAdapter() {
        val adapter = AdapterHeroes()
        binding.rvListado.adapter = adapter

        heroeVM.heroeLiveData().observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }


}