package com.example.shoplist.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.shoplist.R
import com.example.shoplist.presentation.activity.ShopItemActivity
import com.example.shoplist.presentation.rcview.ShopListAdapter
import com.example.shoplist.presentation.viewmodel.MainViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adaptervar: ShopListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRcView()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.shopList.observe(this) {
            adaptervar.submitList(it)

        }
        val buttonAdd = findViewById<FloatingActionButton>(R.id.button_add_shop_item)
        buttonAdd.setOnClickListener {
            val intent = ShopItemActivity.newIntentAddItem(this)
            startActivity(intent)
        }


    }


    private fun setupRcView() {
        val rcView = findViewById<RecyclerView>(R.id.rv_shop_list)
        adaptervar = ShopListAdapter()
        rcView.adapter = adaptervar

        rcView.recycledViewPool.setMaxRecycledViews(
            ShopListAdapter.VIEW_TYPE_ENABLED, ShopListAdapter.MAX_SIZE_POOL
        )
        rcView.recycledViewPool.setMaxRecycledViews(
            ShopListAdapter.VIEW_TYPE_DISABLED, ShopListAdapter.MAX_SIZE_POOL

        )



        setupLongClick()
        setupClick()
        setupSwipe(rcView)

    }

    private fun setupSwipe(rcView: RecyclerView?) {
        val helper =
            object :
                ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val item = adaptervar.currentList[viewHolder.adapterPosition]
                    viewModel.delete(item)
                }

            }
        val itemTouch = ItemTouchHelper(helper)
        itemTouch.attachToRecyclerView(rcView)
    }

    private fun setupLongClick() {
        adaptervar.setLongClickListener = {
            viewModel.editTrueFalse(it)
        }
    }

    private fun setupClick() {
        adaptervar.setOnClickListener = {
            Log.d("MAin", it.toString())
            val newIntent = ShopItemActivity.newIntentEditItem(this, it.id)
            startActivity(newIntent)
        }
    }


}