package com.awakelab.oskar.superheroesv2.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_heroe_detalle")
data class DetalleEntity(
    @PrimaryKey
    val id: Int,
    val nombre: String,
    val origen: String,
    val imagenLink: String,
    val poder: String,
    val anioCreacion: Int,
    val color: String,
    val traduccion: Boolean,
)
