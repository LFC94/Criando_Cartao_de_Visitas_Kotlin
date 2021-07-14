package br.com.lfcapp.cartodevisita.util

import android.content.Context
import android.widget.Toast

class Uteis {

    companion object {
        fun toast(context: Context, texto: String, duration: Int = Toast.LENGTH_SHORT) {
            Toast.makeText(context, texto, duration).show()
        }
    }
}

