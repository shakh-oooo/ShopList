package com.example.shoplist.domain.usecases

import com.example.shoplist.domain.ShopList
import com.example.shoplist.domain.ShopListRepository

class GetShopListUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopList():List<ShopList>{
        return shopListRepository.getShopList()
    }
}