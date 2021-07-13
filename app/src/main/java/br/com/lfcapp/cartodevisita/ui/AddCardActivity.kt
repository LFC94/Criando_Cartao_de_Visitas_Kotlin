package br.com.lfcapp.cartodevisita.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.lfcapp.cartodevisita.databinding.ActivityAddCardBinding

class AddCardActivity : AppCompatActivity() {
    private val binding by lazy { ActivityAddCardBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}