package com.example.shoplist.domain.usecases.items

import com.example.shoplist.domain.ShopList
import com.example.shoplist.domain.ShopListRepository

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopItem(shopItemId : Int):ShopList{
     return shopListRepository.getShopItem(shopItemId)
    }
}