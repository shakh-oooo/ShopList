package com.example.shoplist.domain.usecases.items

import com.example.shoplist.domain.ShopList
import com.example.shoplist.domain.ShopListRepository


class AddShopItemUSeCase(private val shopListRepository: ShopListRepository) {
    fun addShopItem(shopList: ShopList){
        shopListRepository.addShopItem(shopList)
    }
}