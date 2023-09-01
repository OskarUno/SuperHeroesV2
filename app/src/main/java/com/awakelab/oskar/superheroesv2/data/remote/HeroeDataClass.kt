package com.awakelab.oskar.superheroesv2.data.remote

import com.google.gson.annotations.SerializedName

data class HeroeDataClass(
    @SerializedName("id") var id: Int,
    @SerializedName("nombre") var nombre: String,
    @SerializedName("origen") var origen: String,
    @SerializedName("imagenLink") var imagenLink: String,
    @SerializedName("poder") var poder: String,
    @SerializedName("Año_creacion") var anioCreacion: Int,
)
