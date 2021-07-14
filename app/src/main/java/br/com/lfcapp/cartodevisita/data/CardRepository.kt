package br.com.lfcapp.cartodevisita.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CardRepository(private val dao: CardDao) {

    fun insert(cards: Cards) = runBlocking {
        launch(Dispatchers.IO) {
            dao.insert(cards)
        }
    }

    fun getAll() = dao.getAll()
}