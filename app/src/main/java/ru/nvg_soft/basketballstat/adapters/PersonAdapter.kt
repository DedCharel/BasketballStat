package ru.nvg_soft.basketballstat.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.person.view.*
import ru.nvg_soft.basketballstat.models.Person
import ru.nvg_soft.basketballstat.R


class PersonAdapter:BaseAdapter {
    var listOfPerson = ArrayList<Person>()
    var context:Context? = null
    constructor(context:Context,listOfPerson:ArrayList<Person>){
        this.listOfPerson = listOfPerson
        this.context = context
    }
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var myView = inflater.inflate(R.layout.person,null)
        var person = listOfPerson[p0]
        myView.tvName.text = person.name
        return myView
    }

    override fun getItem(p0: Int): Any {
       return listOfPerson[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return listOfPerson.size
    }
}