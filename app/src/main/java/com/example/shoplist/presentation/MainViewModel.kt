package com.example.shoplist.presentation

import androidx.lifecycle.ViewModel
import com.example.shoplist.data.ShopListRepositoryImpl
import com.example.shoplist.domain.ShopList
import com.example.shoplist.domain.usecases.GetShopListUseCase
import com.example.shoplist.domain.usecases.items.DeleteShopItemUseCase
import com.example.shoplist.domain.usecases.items.EditShopItemUseCase

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)


    val shopList = getShopListUseCase.getShopList()


    /* fun getShopList() {
         val list = getShopListUseCase.getShopList()
         shopList.value = list
 //дает нам список, мы сохряняем данные на лайв дату , что б в дальнейшем получать список , когда мы на него подпишемся
     }*/

    fun delete(shopList: ShopList) {
        deleteShopItemUseCase.deleteShopItem(shopList)
        //удаляет данные функция delete принимает лист (его данные) потом передает на реалезацию (на удаление)
    }

    fun edit(shopList: ShopList) {
        val new = shopList.copy(enabled = !shopList.enabled)
        editShopItemUseCase.editShopItem(new)
        //изменятет true false перемменя New равна копии отрицательную Enabled тоист если нам приходить true он всегда будет false
    }


}