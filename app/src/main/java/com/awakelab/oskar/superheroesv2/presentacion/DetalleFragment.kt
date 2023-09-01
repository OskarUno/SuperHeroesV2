package com.awakelab.oskar.superheroesv2.presentacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import coil.load
import com.awakelab.oskar.superheroesv2.R
import com.awakelab.oskar.superheroesv2.databinding.FragmentDetalleBinding
import com.awakelab.oskar.superheroesv2.databinding.FragmentListadoHeroeBinding

private const val ARG_PARAM1 = "id"

class DetalleFragment : Fragment() {
    private lateinit var binding: FragmentDetalleBinding
    private val heroeVM: HeroeViewModel by activityViewModels()

    private var idParam: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            idParam = it.getInt(ARG_PARAM1)
        }
        heroeVM.getDetalleHeroeVM(idParam)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentDetalleBinding.inflate(layoutInflater,container,false)
        heroeVM.getDetalleHeroeVM(idParam)
        initListener()
        heroeVM.getDetalleHeroeVM(idParam)
        return binding.root
    }

    private fun initListener() {
        idParam?.let { it ->
            heroeVM.detalleLiveData(it).observe(viewLifecycleOwner){
                if(it != null){
                    binding.tvNombreD.text = it.nombre
                    binding.tvId.text = it.id.toString()
                    binding.tvPoder.text = it.poder
                    binding.imgHeroeD.load(it.imagenLink)

                }
            }
        }
    }

}