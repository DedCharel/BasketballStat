package ru.nvg_soft.basketballstat.presenters

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import ru.nvg_soft.basketballstat.actyvities.AddPersonActivity
import ru.nvg_soft.basketballstat.models.DBManager
import ru.nvg_soft.basketballstat.models.Person
import ru.nvg_soft.basketballstat.views.PersonView

@InjectViewState
class PersonPresenter:MvpPresenter<PersonView>() {
    val list = ArrayList<Person>()


    fun loadQuery(context: Context, title:String): ArrayList<Person>{



        var dbManager= DBManager(context)
        val projections= arrayOf("ID","Name", "DOB", "Weight", "Height")
        val selectionArgs= arrayOf(title)
        val cursor=dbManager.Query(projections,"Name like ?",selectionArgs,"Name")
        list.clear()
        if(cursor.moveToFirst()){

            do{
                val id=cursor.getInt(cursor.getColumnIndex("ID"))
                val name=cursor.getString(cursor.getColumnIndex("Name"))
                val dob=cursor.getInt(cursor.getColumnIndex("DOB"))
                val height=cursor.getInt(cursor.getColumnIndex("Height"))
                val weight=cursor.getInt(cursor.getColumnIndex("Weight"))

                list.add(Person(id, name, dob, height, weight))

            }while (cursor.moveToNext())
        }
        return list




    }

    fun addPerson(context: Context){
        var intent = Intent(context, AddPersonActivity::class.java)
        context.startActivity(intent)

    }

}