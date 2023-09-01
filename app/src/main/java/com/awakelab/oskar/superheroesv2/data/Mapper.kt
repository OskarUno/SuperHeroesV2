package com.awakelab.oskar.superheroesv2.data

import com.awakelab.oskar.superheroesv2.data.local.DetalleEntity
import com.awakelab.oskar.superheroesv2.data.local.HeroeEntity
import com.awakelab.oskar.superheroesv2.data.remote.DetalleDataClass
import com.awakelab.oskar.superheroesv2.data.remote.HeroeDataClass

fun HeroeDataClass.transEntity(): HeroeEntity = HeroeEntity(
    this.id,
    this.nombre,
    this.origen,
    this.imagenLink,
    this.poder,
    this.anioCreacion
)

fun DetalleDataClass.transDetalle(): DetalleEntity = DetalleEntity(
    this.id,
    this.nombre,
    this.origen,
    this.imagenLink,
    this.poder,
    this.anioCreacion,
    this.color,
    this.traduccion
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
 */

/*
    @SerializedName("id"           ) var id           : Int?    = null,
    @SerializedName("nombre"       ) var nombre       : String? = null,
    @SerializedName("origen"       ) var origen       : String? = null,
    @SerializedName("imagenLink"   ) var imagenLink   : String? = null,
    @SerializedName("poder"        ) var poder        : String? = null,
    @SerializedName("Año_creacion" ) var anioCreacion : Int?    = null
 */