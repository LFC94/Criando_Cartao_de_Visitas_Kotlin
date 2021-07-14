package br.com.lfcapp.cartodevisita.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CardDao {

    @Query("SELECT * FROM cards")
    fun getAll(): LiveData<List<Cards>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(cards: Cards)
}