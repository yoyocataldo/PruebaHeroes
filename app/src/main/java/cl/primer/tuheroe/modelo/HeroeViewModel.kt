package cl.primer.tuheroe.modelo

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.primer.tuheroe.Heroe
import kotlinx.coroutines.launch

class HeroeViewModel: ViewModel() {
    private val repositorio = RepoHeroe()
    val heroes = repositorio.heroList

    init {
        viewModelScope.launch {
            Log.d(TAG, "PIFIA")
            repositorio.getHeroes()
        }
    }
    fun selected(): LiveData<Heroe> = selected
    private val selected=MutableLiveData<Heroe>()
    fun selected(heroe:Heroe){
        selected.value=heroe
}
}