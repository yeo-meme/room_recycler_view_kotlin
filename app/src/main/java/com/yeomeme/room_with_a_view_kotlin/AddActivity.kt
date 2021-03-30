package com.yeomeme.room_with_a_view_kotlin

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.add_activity.*

/**

 * Created by yeomeme@gmail.com on 2021-03-30
 *
 */
class AddActivity :AppCompatActivity() {

    private var catDb : CatDb? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_activity)
        catDb = CatDb.getInstance(this)

        val addRunnable = Runnable {
            val newCat = Cat()
            newCat.catName = addName.text.toString()
            newCat.lifeSpan = addLifeSpan.text.toString().toInt()
            newCat.origin = addOrigin.text.toString()
            catDb?.catDao()?.insert(newCat)
        }


        addBtn.setOnClickListener {
            val addThread = Thread(addRunnable)
            addThread.start()

            var i = Intent(this, MainActivity::class.java)
            startActivity(i)
            finish()
        }
    }

    override fun onDestroy() {
        CatDb.destroyInstance()
        super.onDestroy()
    }
}