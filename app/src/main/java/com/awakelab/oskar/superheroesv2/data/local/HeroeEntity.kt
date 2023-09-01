package com.awakelab.oskar.superheroesv2.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_heroe")
data class HeroeEntity(
     @PrimaryKey
    val id          :Int,
    val nombre      : String,
    val origen      : String,
    val imagenLink  : String,
    val poder       :String,
    val anioCreacion:Int,
)

/*
    @SerializedName("id"           ) var id           : Int?    = null,
    @SerializedName("nombre"       ) var nombre       : String? = null,
    @SerializedName("origen"       ) var origen       : String? = null,
    @SerializedName("imagenLink"   ) var imagenLink   : String? = null,
    @SerializedName("poder"        ) var poder        : String? = null,
    @SerializedName("Año_creacion" ) var anioCreacion : Int?    = null
 */