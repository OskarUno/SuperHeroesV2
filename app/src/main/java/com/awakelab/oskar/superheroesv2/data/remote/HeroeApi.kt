package com.awakelab.oskar.superheroesv2.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

//https://y-mariocanedo.vercel.app/superheroes/

interface HeroeApi {

    //Listado Heroes
    @GET("superheroes/")
    suspend fun getData(): Response<List<HeroeDataClass>>


    //https://y-mariocanedo.vercel.app/superheroes/3
    //Un Heroe
    @GET("superheroes/{id}")
    suspend fun getDataDetalle(@Path("id") id: Int): Response<DetalleDataClass>
}

