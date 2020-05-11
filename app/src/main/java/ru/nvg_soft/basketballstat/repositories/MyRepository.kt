package ru.nvg_soft.basketballstat.repositories

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.nvg_soft.basketballstat.models.Event
import ru.nvg_soft.basketballstat.models.Person
import ru.nvg_soft.basketballstat.models.database.EventDao
import ru.nvg_soft.basketballstat.models.database.MyDatabase
import ru.nvg_soft.basketballstat.models.database.PersonDao

class MyRepository(applicationContext: Application) {
    private lateinit var personDao: PersonDao
   // private lateinit var eventDao: EventDao


    companion object{
        @Volatile private var INSTANCE : MyRepository? = null

        fun getInstance(applicationContext: Application): MyRepository? {
            if (INSTANCE == null) {
                synchronized(MyRepository::class) {
                    INSTANCE = MyRepository(applicationContext)
                }
            }
            return INSTANCE
        }
    }
    init {
        val database = MyDatabase.getInstance(applicationContext.applicationContext)
        Log.d("M_MyRepository","$database")
        personDao = database!!.personDao()
    }

    //Person
     fun getAllPerson():LiveData<List<Person>> = personDao.getAllPerson()

    suspend fun deletePerson(person: Person) = withContext(Dispatchers.IO){personDao.deletePerson(person)}

    suspend fun updatePerson(person: Person) = withContext(Dispatchers.IO){personDao.updatePerson(person)}

    suspend fun insertPerson(person: Person) = withContext(Dispatchers.IO){personDao.insertAllPerson(person)}
     fun insertPerson1(person: Person) = personDao.insertPerson(person)
    //Event

   /*  fun getAllEvent():LiveData<List<Event>> = eventDao.getAllEvents()

    suspend fun deleteEvent(event: Event) = withContext(Dispatchers.IO){eventDao.deleteEvent(event)}

    suspend fun updateEvent(event: Event) = withContext(Dispatchers.IO){eventDao.updateEvent(event)}

    suspend fun insertEvent(event: Event) = withContext(Dispatchers.IO){eventDao.insertEvent()}*/


}