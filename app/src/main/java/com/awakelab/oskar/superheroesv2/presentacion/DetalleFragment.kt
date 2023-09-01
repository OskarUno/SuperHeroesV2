package com.awakelab.oskar.superheroesv2.presentacion

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
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
        binding = FragmentDetalleBinding.inflate(layoutInflater, container, false)
        heroeVM.getDetalleHeroeVM(idParam)
        initListener()
        heroeVM.getDetalleHeroeVM(idParam)
        return binding.root
    }

    private fun initListener() {
        idParam?.let { it ->
            heroeVM.detalleLiveData(it).observe(viewLifecycleOwner) { heroeDetalle ->
                if (heroeDetalle != null) {
                    binding.tvId.text = heroeDetalle.id.toString()
                    binding.tvNombreD.text = heroeDetalle.nombre
                    binding.tvAnioD.text =
                        getString(R.string.anio_creacion) + heroeDetalle.anioCreacion.toString()
                    binding.tvOrigen.text = "Lugar de Origen: " + heroeDetalle.origen
                    binding.tvColor.text = "Color Favorito: " + heroeDetalle.color
                    binding.tvPoder.text = "Habilidad: " + heroeDetalle.poder
                    binding.imgHeroeD.load(heroeDetalle.imagenLink)
                    if (heroeDetalle.traduccion) {
                        binding.tvTraduccionTrue.visibility = View.VISIBLE
                    } else {
                        binding.tvTraduccionFalse.visibility = View.VISIBLE
                    }
                    binding.cvMail.setOnClickListener {
                        val nombreHeroe = binding.tvNombreD.text.toString()
                        enviarEmail(nombreHeroe)
                    }
                }
            }
        }
    }

    private fun enviarEmail(nombreHeroe: String) {
        val para = arrayOf("Comicconchile@hotmail.com")
        val copia = arrayOf("")
        val asunto = "Votación, $nombreHeroe"

        val mensaje =
            "Hola\n\n Quiero que el siguiente super héroes, $nombreHeroe, aparezca, en la nueva edición de biografías animadas. \n\nNumero contacto:__________\n\nGracias."
        //  val asunto  = getString(R.string.asuntoCorreo, producto, idParam)
        //  val mensaje = getString(R.string.mensajeCorreo, producto, idParam)

        val emailIntent = Intent(Intent.ACTION_SEND)
        Uri.parse("mailto:").also { emailIntent.data = it }
        emailIntent.type = "text/plain"
        emailIntent.putExtra(Intent.EXTRA_EMAIL, para)
        emailIntent.putExtra(Intent.EXTRA_CC, copia)
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, asunto)
        emailIntent.putExtra(Intent.EXTRA_TEXT, mensaje)

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."))
            Log.i("Detalle Fragment Email", "Finished sending email...")
        } catch (ex: ActivityNotFoundException) {
            Log.i("Detalle Fragment Email", "Email no enviado")
        }
    }

}