package com.example.shoplist.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.shoplist.R
import com.example.shoplist.presentation.rcview.ShopListAdapter
import com.example.shoplist.presentation.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: ShopListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRcView()
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.shopList.observe(this) {
            adapter.shopListFromAdapter = it

        }
    }


    private fun setupRcView() {
        val rcView = findViewById<RecyclerView>(R.id.rv_shop_list)
        adapter = ShopListAdapter()
        rcView.adapter = adapter

        rcView.recycledViewPool.setMaxRecycledViews(
            ShopListAdapter.VIEW_TYPE_ENABLED,
            ShopListAdapter.MAX_SIZE_POOL
        )
        rcView.recycledViewPool.setMaxRecycledViews(
            ShopListAdapter.VIEW_TYPE_DISABLED,
            ShopListAdapter.MAX_SIZE_POOL
        )

    }

    /* private fun showList(list: List<ShopList>) {
         llShopList.removeAllViews()
         for (shopItem in list) {
             val layoutId = if (shopItem.enabled) {
                 R.layout.item_shop_enabled
             } else {
                 R.layout.item_shop_disabled
             }
             val view = LayoutInflater.from(this).inflate(layoutId, llShopList, false)
             val tvName = view.findViewById<TextView>(R.id.tv_name)
             val tvCount = view.findViewById<TextView>(R.id.tv_count)
             tvName.text = shopItem.name
             tvCount.text = shopItem.count.toString()
             view.setOnLongClickListener {
                 viewModel.edit(shopItem)
                 true
             }
             llShopList.addView(view)
         }
     }*/
}