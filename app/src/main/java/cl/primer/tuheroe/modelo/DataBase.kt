package cl.primer.tuheroe.modelo

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.*
import cl.primer.tuheroe.Heroe

class DataBase {
    @Dao
    interface HeroDAO {
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertHero(heroList: List<Heroe>)

        @Query("SELECT * FROM superhero_table")
        fun getHeroes(): LiveData<List<Heroe>>

    }

    @Database(entities=[Heroe::class], version=1)
    @TypeConverters(Converters::class)
    abstract class SuperHeroDB: RoomDatabase() {
        abstract fun heroDao(): HeroDAO
    }

    class HeroApplication: Application() {
        companion object {
            var heroDatabase: SuperHeroDB? = null
        }

        override fun onCreate(){
            super.onCreate()

            heroDatabase = Room
                .databaseBuilder(this, SuperHeroDB::class.java, "heroes_db")
                .build()
        }
    }
}
