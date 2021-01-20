package cl.primer.tuheroe.modelo

import android.util.Log

class RepoHeroe {
    val heroDatabase = DataBase.HeroApplication.heroDatabase!!
    val heroList = heroDatabase.heroDao().getHeroes()

    suspend fun getHeroes() {

        val response = RetrofitClient.instance().listaHeroe()
        when (response.isSuccessful){
            true -> {
                response.body()?.let { heroesList ->
                    Log.d("Repo", "getHeroes:${response.body()} ")
                    heroDatabase.heroDao().insertHero(heroesList)
                }
            }

            false -> {
                Log.d("Repo", "Error:: ${response.errorBody()}")
}
    }
}
}