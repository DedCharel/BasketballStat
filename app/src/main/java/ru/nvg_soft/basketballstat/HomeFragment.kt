package ru.nvg_soft.basketballstat

import android.os.Bundle
import android.provider.ContactsContract
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {
    val list = ArrayList<Person>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val myView = inflater.inflate(R.layout.fragment_home,container,false)
        val  myListView = myView.findViewById<ListView>(R.id.lvPerson)

        list.add(Person("Bdfyjd"))
        list.add(Person("Bdfyj74"))
        list.add(Person("Bdfyjd5555"))
        myListView.adapter = PersonAdapter(inflater.context,listOfPerson = list )
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
        var dbManager=DBManager(layoutInflater.context)
        val projections= arrayOf("name")
        val selectionArgs= arrayOf(title)
        val cursor=dbManager.Query(projections,"Title like ?",selectionArgs,"Name")
        list.clear()
        if(cursor.moveToFirst()){

            do{
                val name=cursor.getString(cursor.getColumnIndex("name")
                )

                list.add(Person(name))

            }while (cursor.moveToNext())
        }

        var myPersonAdapter= PersonAdapter(layoutInflater.context, list)
        lvPerson.adapter=myPersonAdapter

    }
}