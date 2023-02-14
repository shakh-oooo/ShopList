package com.example.shoplist.presentation.rcview

import androidx.recyclerview.widget.DiffUtil
import com.example.shoplist.domain.ShopList

class ShopItemCallback:DiffUtil.ItemCallback<ShopList>() {
    override fun areItemsTheSame(oldItem: ShopList, newItem: ShopList): Boolean {
        return oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItem: ShopList, newItem: ShopList): Boolean {
        return oldItem==newItem
    }
}