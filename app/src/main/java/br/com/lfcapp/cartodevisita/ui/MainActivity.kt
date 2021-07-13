package br.com.lfcapp.cartodevisita.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.lfcapp.cartodevisita.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListener()
    }

    private fun insertListener() {
        binding.fabAdd.setOnClickListener {
            var intent = Intent(this@MainActivity, AddCardActivity::class.java)
            startActivity(intent)
        }
    }
}