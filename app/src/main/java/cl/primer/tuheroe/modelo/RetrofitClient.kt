package cl.primer.tuheroe.modelo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {
        private const val BASE_URL = "https://akabab.github.io/superhero-api/api/"

        suspend fun instance(): HeroeApi {
            val retrofit = Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(HeroeApi::class.java)


        }
    }

}