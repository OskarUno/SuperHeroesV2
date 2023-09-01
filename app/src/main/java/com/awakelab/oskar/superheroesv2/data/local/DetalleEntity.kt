package com.awakelab.oskar.superheroesv2.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_heroe_detalle")
data class DetalleEntity(
    @PrimaryKey
    val id          : Int,
    val nombre      : String,
    val origen      : String,
    val imagenLink  : String,
    val poder       : String,
    val anioCreacion: Int,
    val color       : String,
    val traduccion  : Boolean,
)

/*
    @SerializedName("id"           ) var id          : Int,
    @SerializedName("nombre"       ) var nombre      : String,
    @SerializedName("origen"       ) var origen      : String,
    @SerializedName("imagenLink"   ) var imagenLink  : String,
    @SerializedName("poder"        ) var poder       : String,
    @SerializedName("año_creacion" ) var anioCreacion : Int,
    @SerializedName("color"        ) var color       : String,
    @SerializedName("traduccion"   ) var traduccion  : Boolean
)
 */