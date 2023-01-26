package com.example.shoplist.domain

interface ShopListRepository {

    fun addShopItem(shopItem: ShopList)
    fun deleteShopItem(shopItem: ShopList)
    fun editShopItem(shopItem: ShopList)
    fun getShopItem(shopItemId : Int):ShopList

    fun getShopList():List<ShopList>


}