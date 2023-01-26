package com.example.shoplist.domain

interface ShopListRepository {

    fun addShopItem(shopList: ShopList)
    fun deleteShopItem(shopList: ShopList)
    fun editShopItem(shopList: ShopList)
    fun getShopItem(shopItemId : Int):ShopList

    fun getShopList():List<ShopList>


}