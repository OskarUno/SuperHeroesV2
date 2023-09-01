package com.awakelab.oskar.superheroesv2.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_heroe")
data class HeroeEntity(
    @PrimaryKey
    val id: Int,
    val nombre: String,
    val origen: String,
    val imagenLink: String,
    val poder: String,
    val anioCreacion: Int,
)