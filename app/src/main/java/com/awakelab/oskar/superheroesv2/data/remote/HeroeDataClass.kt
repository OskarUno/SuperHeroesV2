package com.awakelab.oskar.superheroesv2.data.remote

import com.google.gson.annotations.SerializedName

data class HeroeDataClass(
    @SerializedName("id"           ) var id           : Int,
    @SerializedName("nombre"       ) var nombre       : String,
    @SerializedName("origen"       ) var origen       : String,
    @SerializedName("imagenLink"   ) var imagenLink   : String,
    @SerializedName("poder"        ) var poder        : String,
    @SerializedName("Año_creacion" ) var anioCreacion : Int
)

/*
    {
        "id": 1,
        "nombre": "BATMAN",
        "origen": "Gotham City",
        "imagenLink": "https://cloudfront-us-east-1.images.arcpublishing.com/metroworldnews/OMMXHLDAABDBVHRUH2FPDLVZCY.jpg",
        "poder": "No tiene super poderes, recurre a su intelecto",
        "Año_creacion": 1939
    },
 */