package ru.nvg_soft.basketballstat.models.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.nvg_soft.basketballstat.models.Event
import ru.nvg_soft.basketballstat.models.Person


//@Database(entities = [Person::class, Event::class], version = 1)
@Database(entities = [Person::class], version = 1)
abstract class MyDatabase:RoomDatabase() {
    abstract fun personDao():PersonDao
  //  abstract fun eventDao():EventDao
    companion object {
        @Volatile
        private var instance: MyDatabase? = null

      fun getInstance(context: Context): MyDatabase? {
          if (instance == null) {
              synchronized(MyDatabase::class) {
                  instance = Room.databaseBuilder(
                      context.applicationContext,
                      MyDatabase::class.java, "person_database"
                  )
                      .fallbackToDestructiveMigration()
                      //.addCallback(roomCallback)
                      .allowMainThreadQueries() //все будет в Ui потоке НИКОГДА ТАК НЕ ДЕЛАТЬ!!!
                      .build()
              }
          }
          return instance
      }
    }

    fun destroyInstance(){
        instance = null
    }
}