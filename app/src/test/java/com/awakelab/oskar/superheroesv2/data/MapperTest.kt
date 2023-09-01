package com.awakelab.oskar.superheroesv2.data

import com.awakelab.oskar.superheroesv2.data.local.HeroeEntity
import com.awakelab.oskar.superheroesv2.data.remote.HeroeDataClass
import org.junit.Assert.assertEquals
import org.junit.Test

class MapperTest {
    @Test
    fun transEntity() {
        //Given (Dado este valor)
        val heroeEntity = HeroeEntity(1, "Nombre1", "origen1", "img1", "poder1", 1999)

        val heroeDataClass = HeroeDataClass(1, "Nombre1", "origen1", "img1", "poder1", 1999)

        //When (Hago esta acción)
        val res = heroeDataClass.transEntity()

        //Then (Espero este resultado)
        assertEquals(heroeEntity, res)
    }
}

