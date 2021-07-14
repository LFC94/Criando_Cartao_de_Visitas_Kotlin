package br.com.lfcapp.cartodevisita.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.lfcapp.cartodevisita.App
import br.com.lfcapp.cartodevisita.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    private val adapter by lazy { CardAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvCards.adapter = adapter
        getAllCards()
        insertListener()
    }

    private fun insertListener() {
        binding.fabAdd.setOnClickListener {
            var intent = Intent(this@MainActivity, AddCardActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getAllCards() {
        mainViewModel.getAll().observe(this, { cards ->
            adapter.submitList(cards)
        })
    }
}