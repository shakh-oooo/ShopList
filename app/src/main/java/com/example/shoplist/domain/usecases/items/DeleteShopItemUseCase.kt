package com.example.shoplist.domain.usecases.items

import com.example.shoplist.domain.ShopList
import com.example.shoplist.domain.ShopListRepository

class DeleteShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun deleteShopItem(shopList: ShopList){
        shopListRepository.deleteShopItem(shopList)
    }
}