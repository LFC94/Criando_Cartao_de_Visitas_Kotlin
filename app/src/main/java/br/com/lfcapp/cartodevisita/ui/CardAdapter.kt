package br.com.lfcapp.cartodevisita.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.lfcapp.cartodevisita.data.Cards
import br.com.lfcapp.cartodevisita.databinding.ItemCardBinding

class CardAdapter : ListAdapter<Cards, CardAdapter.viewHolder>(DiffCallback()) {
    var listenerShare: (View) -> Unit = {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        var inflater = LayoutInflater.from(parent.context)
        val binding = ItemCardBinding.inflate(inflater, parent, false)
        return viewHolder(binding)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class viewHolder(
        private val binding: ItemCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Cards) {
            binding.tvNome.text = item.nome
            binding.tvEmail.text = item.email
            binding.tvEmpresa.text = item.empresa
            binding.tvTelefone.text = item.telefone
            binding.mcvContent.setBackgroundColor(item.cor)
            binding.mcvContent.setOnClickListener {
                listenerShare(it)
            }

        }
    }


}

class DiffCallback : DiffUtil.ItemCallback<Cards>() {
    override fun areItemsTheSame(oldItem: Cards, newItem: Cards) = oldItem == newItem

    override fun areContentsTheSame(oldItem: Cards, newItem: Cards) = oldItem.id == newItem.id

}