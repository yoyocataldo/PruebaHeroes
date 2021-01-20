package cl.primer.tuheroe.modelo

import cl.primer.tuheroe.Heroe
import retrofit2.Response
import retrofit2.http.GET

interface HeroeApi {
    @GET("all.json")
   suspend fun listaHeroe(): Response<List<Heroe>>

}
