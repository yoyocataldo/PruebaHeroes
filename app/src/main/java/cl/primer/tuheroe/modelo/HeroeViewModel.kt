package cl.primer.tuheroe.modelo

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
    fun a(){
}
}