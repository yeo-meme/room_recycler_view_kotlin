package com.yeomeme.room_with_a_view_kotlin

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.OnConflictStrategy.REPLACE

/**

 * Created by yeomeme@gmail.com on 2021-03-30
 *
 */
@Dao
interface CatDao {

  @Query("SELECT * FROM cat")
  fun getAll() : List<Cat>

/*import android.arch.persistence.room.OnConflictStrategy.REPLACE*/
  @Insert(onConflict = REPLACE)
  fun insert(cat: Cat)

  @Query("DELETE from cat")
  fun deleteAll()
}