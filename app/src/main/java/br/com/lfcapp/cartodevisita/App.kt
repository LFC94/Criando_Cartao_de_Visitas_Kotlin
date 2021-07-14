package br.com.lfcapp.cartodevisita

import android.app.Application
import br.com.lfcapp.cartodevisita.data.AppDatabase
import br.com.lfcapp.cartodevisita.data.CardRepository

class App : Application() {

    val database by lazy { AppDatabase.getDataBase(this) }
    val repository by lazy { CardRepository(database.cardDao()) }

}