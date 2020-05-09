package ru.nvg_soft.basketballstat.repositories

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.nvg_soft.basketballstat.models.Event
import ru.nvg_soft.basketballstat.models.Person
import ru.nvg_soft.basketballstat.models.database.EventDao
import ru.nvg_soft.basketballstat.models.database.PersonDao

class Repository {
    private lateinit var personDao: PersonDao
    private lateinit var eventDao: EventDao

    companion object{
        @Volatile private var INSTANCE:Repository? = null

        fun getInstance():Repository{
            return INSTANCE ?: Repository()
        }
    }
    init {
        val database = Repository.getInstance()
        personDao = database!!.personDao
        eventDao = database!!.eventDao
    }

    //Person
     fun getAllPerson():LiveData<List<Person>> = personDao.getAllPerson()

    suspend fun deletePerson(person: Person) = withContext(Dispatchers.IO){personDao.deletePerson(person)}

    suspend fun updatePerson(person: Person) = withContext(Dispatchers.IO){personDao.updatePerson(person)}

    suspend fun insertPerson(person: Person) = withContext(Dispatchers.IO){personDao.insertPerson(person)}

    //Event

     fun getAllEvent():LiveData<List<Event>> = eventDao.getAllEvents()

    suspend fun deleteEvent(event: Event) = withContext(Dispatchers.IO){eventDao.deleteEvent(event)}

    suspend fun updateEvent(event: Event) = withContext(Dispatchers.IO){eventDao.updateEvent(event)}

    suspend fun insertEvent(event: Event) = withContext(Dispatchers.IO){eventDao.insertEvent()}


}