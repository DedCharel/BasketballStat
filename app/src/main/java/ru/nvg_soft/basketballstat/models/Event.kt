package ru.nvg_soft.basketballstat.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Event (
    @PrimaryKey(autoGenerate = true)val id: Int,
    val name: String
)