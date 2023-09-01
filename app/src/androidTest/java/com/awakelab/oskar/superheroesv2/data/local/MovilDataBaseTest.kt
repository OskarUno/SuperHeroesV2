package com.awakelab.oskar.superheroesv2.data.local

import android.content.Context
import androidx.annotation.VisibleForTesting
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

class MovilDataBaseTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var breedsDao: HeroeDao
    private lateinit var db: HeroeDataBase

    @Before  //inicializar la ddbb
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, HeroeDataBase::class.java).build()
        breedsDao = db.getHeroeDao()
    }

    @After  //Cerrar lo inicializado
    fun tearDown() {
        db.close()
    }

    @Test
    fun insertBreeds_empty() = runBlocking {
        // Given
        val breedList = listOf<HeroeEntity>()

        // When
        breedsDao.inseterHeroes(breedList)

        // Then A  comprueba que hay una lista y esta vacia. esto luego de haber insertado  bredList
        val it = breedsDao.getAllHeroes().getOrAwaitValue()
        assertThat(it).isNotNull()
        assertThat(it).isEmpty()

        // Then B
        breedsDao.getAllHeroes().observeForever {
            assertThat(it).isNotNull()  // assertNotEquals(it, null)
            assertThat(it).isEmpty()    // assertEquals(it.size, 0)
        }
    }

    @Test
    fun insertBreeds_happyCase_1element() = runBlocking {
        // Given
        val breedList = listOf(HeroeEntity(1, "Nombre1", "origen1", "img1", "poder1", 1999))

        // When
        breedsDao.inseterHeroes(breedList)

        // Then   (assertThat = valida esto!!!!!
        breedsDao.getAllHeroes().observeForever {
            assertThat(it).isNotNull()
            assertThat(it).isNotEmpty()
            assertThat(it).hasSize(1)
        }
    }

    @Test
    fun insertBreeds_happyCase_3elements() = runBlocking {
        // Given
        val breedList = listOf(
            HeroeEntity(1, "Nombre1", "origen1", "img1", "poder1", 1999),
            HeroeEntity(2, "Nombre2", "origen2", "img2", "poder2", 2000),
            HeroeEntity(3, "Nombre3", "origen3", "img3", "poder3", 2001),
        )

        // When
        breedsDao.inseterHeroes(breedList)

        // Then
        breedsDao.getAllHeroes().observeForever {
            assertThat(it).isNotNull()
            assertThat(it).isNotEmpty()
            assertThat(it).hasSize(3)
        }
    }
}

//Se crea una funcion de extension,
@VisibleForTesting(otherwise = VisibleForTesting.NONE)
fun <T> LiveData<T>.getOrAwaitValue(
    time: Long = 2,
    timeUnit: TimeUnit = TimeUnit.SECONDS,
    afterObserve: () -> Unit = {},
): T {
    var data: T? = null
    val latch = CountDownLatch(1)
    val observer = object : Observer<T> {
        override fun onChanged(value: T) {
            data = value
            latch.countDown()
            this@getOrAwaitValue.removeObserver(this)
        }
    }
    this.observeForever(observer)

    try {
        afterObserve.invoke()

        // Don't wait indefinitely if the LiveData is not set.
        if (!latch.await(time, timeUnit)) {
            throw TimeoutException("LiveData value was never set.")
        }

    } finally {
        this.removeObserver(observer)
    }

    @Suppress("UNCHECKED_CAST")
    return data as T

}
