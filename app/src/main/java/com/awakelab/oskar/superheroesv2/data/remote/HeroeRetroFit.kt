package com.awakelab.oskar.superheroesv2.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//https://y-mariocanedo.vercel.app/superheroes/
class HeroeRetroFit {
    companion object {
        private const val URL_BASE = "https://y-mariocanedo.vercel.app/"
        fun getRetrofitHeroe(): HeroeApi {
            val mRetrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return mRetrofit.create(HeroeApi::class.java)
        }
    }
}
