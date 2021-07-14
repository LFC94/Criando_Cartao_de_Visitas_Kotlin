package br.com.lfcapp.cartodevisita.ui

import android.content.DialogInterface
import android.content.res.ColorStateList
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.lfcapp.cartodevisita.R
import br.com.lfcapp.cartodevisita.databinding.ActivityAddCardBinding
import br.com.lfcapp.cartodevisita.util.Uteis
import com.flask.colorpicker.ColorPickerView
import com.flask.colorpicker.builder.ColorPickerClickListener
import com.flask.colorpicker.builder.ColorPickerDialogBuilder


class AddCardActivity : AppCompatActivity() {
    private val binding by lazy { ActivityAddCardBinding.inflate(layoutInflater) }
    var corSelecionada: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListener()
    }

    private fun insertListener() {
        binding.btnClose.setOnClickListener {
            finish();
        }

        binding.btnColor.setOnClickListener {
            val contex = this@AddCardActivity
            ColorPickerDialogBuilder
                .with(contex)
                .initialColor(corSelecionada)
                .setTitle(getString(R.string.lable_escolher_cor))
                .wheelType(ColorPickerView.WHEEL_TYPE.CIRCLE)
                .setPositiveButton("ok", object : ColorPickerClickListener {
                    override fun onClick(
                        dialog: DialogInterface?,
                        selectedColor: Int,
                        allColors: kotlin.Array<Int?>?
                    ) {;
                        corSelecionada = selectedColor
                        binding.btnColor.setBackgroundTintList(ColorStateList.valueOf(corSelecionada))
                    }
                })
                .setNegativeButton("cancelar", object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface?, which: Int) {}
                })
                .build()
                .show()
        }
    }
}