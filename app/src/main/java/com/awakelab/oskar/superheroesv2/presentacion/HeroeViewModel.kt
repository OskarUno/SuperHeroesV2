package com.awakelab.oskar.superheroesv2.presentacion

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.awakelab.oskar.superheroesv2.data.Repository
import com.awakelab.oskar.superheroesv2.data.local.HeroeDataBase
import com.awakelab.oskar.superheroesv2.data.remote.HeroeRetroFit
import kotlinx.coroutines.launch

class HeroeViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: Repository

    fun heroeLiveData() = repository.obtenerListHeroeEntity()

    init {
        val api = HeroeRetroFit.getRetrofitHeroe()
        val dao = HeroeDataBase.getDatabase(application).getHeroeDao()
        repository = Repository(api,dao)
    }

    fun getAllHereoesVM() = viewModelScope.launch {
        repository.obtenerHeroesApi()
    }
}
