package ru.nvg_soft.basketballstat.models.database

import androidx.lifecycle.LiveData
import androidx.room.*
import ru.nvg_soft.basketballstat.models.Person

@Dao
interface PersonDao {
    @Query("SELECT * FROM person ORDER BY name")
    fun getAllPerson(): LiveData<List<Person>>

    @Insert
    fun insertPerson(vararg person: Person)

    @Delete
    fun deletePerson(person: Person)

    @Update
    fun updatePerson(person: Person)
}