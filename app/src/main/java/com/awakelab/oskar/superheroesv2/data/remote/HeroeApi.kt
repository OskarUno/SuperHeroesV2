package com.awakelab.oskar.superheroesv2.data.remote

import retrofit2.Response
import retrofit2.http.GET

//https://y-mariocanedo.vercel.app/superheroes/
interface HeroeApi {
    //Listado Heroe
    @GET("superheroes/")
    suspend fun getData(): Response<List<HeroeDataClass>>
}

