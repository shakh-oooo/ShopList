package com.example.shoplist.domain.usecases.items

import com.example.shoplist.domain.ShopList
import com.example.shoplist.domain.ShopListRepository

class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun editShopItem(shopList: ShopList){
        shopListRepository.editShopItem(shopList)
    }
}