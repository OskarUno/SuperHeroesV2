package com.awakelab.oskar.superheroesv2.data.remote

import com.google.gson.annotations.SerializedName

data class DetalleDataClass(
    @SerializedName("id"           ) var id          : Int,
    @SerializedName("nombre"       ) var nombre      : String,
    @SerializedName("origen"       ) var origen      : String,
    @SerializedName("imagenLink"   ) var imagenLink  : String,
    @SerializedName("poder"        ) var poder       : String,
    @SerializedName("año_creacion" ) var anioCreacion : Int,
    @SerializedName("color"        ) var color       : String,
    @SerializedName("traduccion"   ) var traduccion  : Boolean
)

/*
{
    "id": 3,
    "nombre": "GOKU",
    "origen": "planeta Vegeta",
    "imagenLink": "https://www.fayerwayer.com/resizer/-QNNwdjZX7xzDXL_9DEFH18PTqk=/arc-photo-metroworldnews/arc2-prod/public/55QHEOQRQBEPTF5LRJK57MDEP4.jpg",
    "poder": "Es capaz de utilizar el Poder Saiyan, el cual le permite sobrepasar su fuerza cada vez que recibe grandes cantidades de daño o heridas mortales",
    "año_creacion": 1985,
    "color": "naranja",
    "traduccion": "true"
}
 */
