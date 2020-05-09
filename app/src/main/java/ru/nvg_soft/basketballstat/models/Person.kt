package ru.nvg_soft.basketballstat.models

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Person(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val dob: Int,
    val height: Int,
    val weight: Int)