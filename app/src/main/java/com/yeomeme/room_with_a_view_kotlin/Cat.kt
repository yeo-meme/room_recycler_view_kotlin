package com.yeomeme.room_with_a_view_kotlin

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**

 * Created by yeomeme@gmail.com on 2021-03-30
 *
 */

@Entity(tableName = "cat")
data class Cat(
    @PrimaryKey
    var id : Long?,
    @ColumnInfo(name = "word") var catName : String?,
    @ColumnInfo(name = "lifespan") var lifeSpan : Int,
    @ColumnInfo(name = "origin") var origin : String
) {
    constructor() : this(null, "", 0, "")
}
