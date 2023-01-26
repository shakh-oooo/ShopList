package com.example.shoplist.data

import com.example.shoplist.domain.ShopList
import com.example.shoplist.domain.ShopListRepository

object ShopListRepositoryImpl : ShopListRepository {

    private var shopList = mutableListOf<ShopList>()

    private var idd = 0

    override fun addShopItem(shopItem: ShopList) {
        if (shopItem.id==ShopList.UNDEFINE_ID){
            shopItem.id = idd++
        }

        shopList.add(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopList) {
        shopList.remove(shopItem)
    }

    override fun editShopItem(shopItem: ShopList) {
        val oldElemnt = getShopItem(shopItem.id)
        shopList.remove(oldElemnt)
        addShopItem(shopItem)
    }

    override fun getShopItem(shopItemId: Int): ShopList {
        return shopList.find { it.id == shopItemId }
            ?: throw java.lang.RuntimeException("not found")
    }

    override fun getShopList(): List<ShopList> {
        return shopList.toList()
    }
}