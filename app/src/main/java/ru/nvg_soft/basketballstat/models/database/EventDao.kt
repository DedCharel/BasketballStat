package ru.nvg_soft.basketballstat.models.database

import androidx.lifecycle.LiveData
import androidx.room.*
import ru.nvg_soft.basketballstat.models.Event

@Dao
interface EventDao {
    @Query("SELECT * FROM event ")
    fun getAllEvents(): LiveData<List<Event>>

    @Insert
    fun insertEvent(vararg event: Event)

    @Delete
    fun deleteEvent(event: Event)

    @Update
    fun updateEvent(event: Event)
}