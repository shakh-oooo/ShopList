package com.example.shoplist.presentation.rcview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.shoplist.R
import com.example.shoplist.domain.ShopList

class ShopListAdapter : RecyclerView.Adapter<ShopListAdapter.ShopItemViewHolder>() {

    var shopListFromAdapter = listOf<ShopList>()
        @SuppressLint("NotifyDataSetChanged") set(value) {
            field = value
            notifyDataSetChanged()

        }

    class ShopItemViewHolder(val view: View) : ViewHolder(view) {
        val tvName = view.findViewById<TextView>(R.id.tv_name)
        val tvCount = view.findViewById<TextView>(R.id.tv_count)

        //этот класс нужен для того чтоб инициализировать айтэмы в наших проектах,
        //чтоб дальнейшем получить адреса потом их не искать каждый раз
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {

        val layout = when (viewType) {
            VIEW_TYPE_ENABLED -> R.layout.item_shop_enabled
            VIEW_TYPE_DISABLED -> R.layout.item_shop_disabled
            else -> throw java.lang.RuntimeException("Unknown view type (не известный тип) $viewType")
        }

        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ShopItemViewHolder(view)

        //этот класс нужен для того чтоб сдувать класс из view  столько раз сколько понадбится
    }

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        val shoppItem = shopListFromAdapter[position]
        holder.view.setOnLongClickListener { true }

        if (shoppItem.enabled) {
            holder.tvName.text = "${shoppItem.name} enabled"
            holder.tvCount.text = shoppItem.count.toString()
        } else {
            holder.tvName.text = "${shoppItem.name} falsefalsefalse"
            holder.tvCount.text = shoppItem.count.toString()
            // если он переиспользует виюв то как тогда он помнит что изначально было у первых виюв?
        }

        //этот класс присваевает айтемы к нужнам элемантам
        //обрабатывает нажатие и т.д.
    }

    override fun getItemViewType(position: Int): Int {
        val item = shopListFromAdapter[position]
        return if (item.enabled) VIEW_TYPE_ENABLED
        else VIEW_TYPE_DISABLED
        //класс нужен для того чтоб менять макеты

    }

    override fun getItemCount(): Int {
        return shopListFromAdapter.size
    }

    companion object {
        const val VIEW_TYPE_ENABLED = 1
        const val VIEW_TYPE_DISABLED = 2

        const val MAX_SIZE_POOL = 15
    }

}