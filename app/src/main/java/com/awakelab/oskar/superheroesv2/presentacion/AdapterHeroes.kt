package com.awakelab.oskar.superheroesv2.presentacion

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.awakelab.oskar.superheroesv2.data.local.HeroeEntity
import com.awakelab.oskar.superheroesv2.databinding.ItemHeroeBinding

class AdapterHeroes : RecyclerView.Adapter<AdapterHeroes.ItemHeroesViewHolder>() {
    lateinit var binding: ItemHeroeBinding
    private val listItemHeroes = mutableListOf<HeroeEntity>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ItemHeroesViewHolder {
        binding = ItemHeroeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemHeroesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listItemHeroes.size
    }

    override fun onBindViewHolder(holder: ItemHeroesViewHolder, position: Int) {
        val heroeItem = listItemHeroes[position]
        holder.render(heroeItem)
    }

    fun setData(heroes: List<HeroeEntity>) {
        this.listItemHeroes.clear()
        this.listItemHeroes.addAll(heroes)
        notifyDataSetChanged()
    }

    class ItemHeroesViewHolder(val heroes: ItemHeroeBinding) :
        RecyclerView.ViewHolder(heroes.root) {
        fun render(heroeItem: HeroeEntity) {
            heroes.tvNombre.text = heroeItem.nombre
            heroes.imgPortada.load(heroeItem.imagenLink)
        }
    }
}