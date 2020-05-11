package ru.nvg_soft.basketballstat.models.database

import androidx.lifecycle.LiveData
import androidx.room.*
import ru.nvg_soft.basketballstat.models.Person
import androidx.room.Dao

@Dao
interface PersonDao {
    @Query("SELECT * FROM person")
    fun getAllPerson(): LiveData<List<Person>>

    @Insert
    suspend fun insertAllPerson(vararg person: Person)
    @Insert
    fun insertPerson(person: Person)

    @Delete
    fun deletePerson(person: Person)

    @Update
    fun updatePerson(person: Person)
}