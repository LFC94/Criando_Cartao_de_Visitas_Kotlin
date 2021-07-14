package br.com.lfcapp.cartodevisita.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.lfcapp.cartodevisita.data.CardRepository
import br.com.lfcapp.cartodevisita.data.Cards

class MainViewModel(private val cardRepository: CardRepository) : ViewModel() {

    fun insert(card: Cards) {
        cardRepository.insert(card)
    }

    fun getAll(): LiveData<List<Cards>> {
        return cardRepository.getAll()
    }
}

class MainViewModelFactory(private val repository: CardRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalAccessException("Unknown ViewModel Class")
    }
}