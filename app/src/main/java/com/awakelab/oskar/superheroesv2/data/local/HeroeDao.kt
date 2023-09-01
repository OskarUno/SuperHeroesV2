package com.awakelab.oskar.superheroesv2.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface HeroeDao {
    //Lista Heroes
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inseterHeroes(heroeEntity: List<HeroeEntity>)

    @Query("SELECT * FROM tabla_heroe ORDER BY id ASC")
    fun getAllHeroes(): LiveData<List<HeroeEntity>>


    //Detalle Heroe


}