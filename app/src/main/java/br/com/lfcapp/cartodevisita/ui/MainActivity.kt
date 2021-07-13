package br.com.lfcapp.cartodevisita.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.lfcapp.cartodevisita.R
import br.com.lfcapp.cartodevisita.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}