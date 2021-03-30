package com.yeomeme.room_with_a_view_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private var catDb: CatDb? = null
    private var catList = listOf<Cat>()
    lateinit var mAdapter : CatAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        catDb = CatDb.getInstance(this)
        mAdapter = CatAdapter(this, catList)

        val r = Runnable {

            try {
                catList = catDb?.catDao()?.getAll()!!
                mAdapter = CatAdapter(this, catList)
                mAdapter.notifyDataSetChanged()

                mRecyclerView.adapter = mAdapter
                mRecyclerView.layoutManager = LinearLayoutManager(this)
                mRecyclerView.setHasFixedSize(true)

            } catch (e: Exception) {
                Log.d("tag", "Error - $e")
            }
        }

        val thread = Thread(r)
        thread.start()

//        adapterJoin();


        mAddBtn.setOnClickListener {
            val i = Intent(this, AddActivity::class.java)
            startActivity(i)
            finish()
        }
    }

//     fun adapterJoin() {
//         var mAdapter = CatAdapter(this, catList)
//         mAdapter.notifyDataSetChanged()
//
//         mRecyclerView.adapter = mAdapter
//         mRecyclerView.layoutManager = LinearLayoutManager(this)
//         mRecyclerView.setHasFixedSize(true)
//    }
}