package ru.nvg_soft.basketballstat.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import kotlinx.android.synthetic.main.fragment_persons.*
import ru.nvg_soft.basketballstat.R
import ru.nvg_soft.basketballstat.adapters.PersonAdapter
import ru.nvg_soft.basketballstat.models.DBManager
import ru.nvg_soft.basketballstat.models.Person

class PersonFragment: Fragment() {
    val list = ArrayList<Person>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val myView = inflater.inflate(R.layout.fragment_persons,container,false)
        loadPersonList()
        showPersonList(myView)
        return myView
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadQuery("%")
    }

    private fun loadQuery(title: String) {
//        var dbManager=
//            DBManager(layoutInflater.context)
//        val projections= arrayOf("name")
//        val selectionArgs= arrayOf(title)
//        val cursor=dbManager.Query(projections,"Title like ?",selectionArgs,"Name")
//        list.clear()
//        if(cursor.moveToFirst()){
//
//            do{
//                val name=cursor.getString(cursor.getColumnIndex("name")
//                )
//
//                list.add(Person(name))
//
//            }while (cursor.moveToNext())
//        }

//        var myPersonAdapter= PersonAdapter(
//            layoutInflater.context,
//            list
//        )
//        lvPerson.adapter=myPersonAdapter

    }

    fun showPersonList(view: View){
        val  myListView = view.findViewById<ListView>(R.id.lvPerson)
        myListView.adapter = PersonAdapter(
            layoutInflater.context,
            listOfPerson = list
        )

    }

    fun loadPersonList(){
        list.add(Person("Иванов Иван"))
        list.add(Person("Петров Петр"))
        list.add(Person("Сергеев Сергей"))
        list.add(Person("Иванов Иван"))
        list.add(Person("Петров Петр"))
        list.add(Person("Сергеев Сергей"))
        list.add(Person("Иванов Иван"))
        list.add(Person("Петров Петр"))
        list.add(Person("Сергеев Сергей"))
        list.add(Person("Иванов Иван"))
        list.add(Person("Петров Петр"))
        list.add(Person("Сергеев Сергей"))
        list.add(Person("Иванов Иван"))
        list.add(Person("Петров Петр"))
        list.add(Person("Сергеев Сергей"))
    }
}