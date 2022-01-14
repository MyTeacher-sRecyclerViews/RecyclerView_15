package com.example.rv_foreground_15

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        val users = addedUserList()
        refreshAdapter(users)
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = GridLayoutManager(this, 1)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        val itemTouchHelperCallBack = RecyclerviewItemTouchHelper(
            0,
            ItemTouchHelper.LEFT,
            object : RecyclerviewItemTouchHelper.RecyclerItemTouchHelperListener {
                override fun onSwiped(
                    viewHolder: RecyclerView.ViewHolder,
                    direction: Int,
                    position: Int
                ) {
                    Log.d("TAG","Swipe")
                }
            })
        ItemTouchHelper(itemTouchHelperCallBack).attachToRecyclerView(recyclerView)
    }

    private fun refreshAdapter(user: ArrayList<User>) {
        val adapter = CustomAdapter(this, user)
        recyclerView.adapter = adapter
    }

    private fun addedUserList(): ArrayList<User> {
        val users = ArrayList<User>()

        for (i in 0..30) {
            users.add(User("Android", "$i"))
        }
        return users
    }
}