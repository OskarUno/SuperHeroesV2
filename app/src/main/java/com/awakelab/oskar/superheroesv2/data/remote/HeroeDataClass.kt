package com.awakelab.oskar.superheroesv2.data.remote

import com.google.gson.annotations.SerializedName

data class HeroeDataClass(
    @SerializedName("id"           ) var id           : Int?    = null,
    @SerializedName("nombre"       ) var nombre       : String? = null,
    @SerializedName("origen"       ) var origen       : String? = null,
    @SerializedName("imagenLink"   ) var imagenLink   : String? = null,
    @SerializedName("poder"        ) var poder        : String? = null,
    @SerializedName("Año_creacion" ) var anioCreacion : Int?    = null
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