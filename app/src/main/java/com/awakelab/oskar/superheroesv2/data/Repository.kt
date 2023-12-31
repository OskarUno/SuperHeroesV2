package com.awakelab.oskar.superheroesv2.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.awakelab.oskar.superheroesv2.data.local.DetalleEntity
import com.awakelab.oskar.superheroesv2.data.local.HeroeDao
import com.awakelab.oskar.superheroesv2.data.local.HeroeEntity
import com.awakelab.oskar.superheroesv2.data.remote.HeroeApi

class Repository(
    private val heroeApi: HeroeApi,
    private val heroeDao: HeroeDao,
) {
    //Listado Heroes
    fun obtenerListHeroeEntity(): LiveData<List<HeroeEntity>> = heroeDao.getAllHeroes()

    suspend fun obtenerHeroesApi() {
        val respuesta = heroeApi.getData()
        if (respuesta.isSuccessful) {
            val res = respuesta.body()
            res?.let { heroeApi ->
                val heroeEntity = heroeApi.map { it.transEntity() }
                heroeDao.inseterHeroes(heroeEntity)
            }
        } else {
            Log.e("Repository", respuesta.errorBody().toString())
        }
    }

    // Detalle Heroe
    fun obtenerDetalleEntity(id: Int): LiveData<DetalleEntity> = heroeDao.getHeroeDetalle(id)

    suspend fun obtenerDetalleHeroe(id: Int) {
        val res = heroeApi.getDataDetalle(id)
        if (res.isSuccessful) {
            val detalleEntity = res.body()!!.copy()
            heroeDao.insertHeroeDetalle(detalleEntity.transDetalle())
        } else {
            Log.e("Repository", res.errorBody().toString())
        }
    }
}