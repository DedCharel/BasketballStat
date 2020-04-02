package ru.nvg_soft.basketballstat.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import ru.nvg_soft.basketballstat.R
import ru.nvg_soft.basketballstat.adapters.PersonAdapter
import ru.nvg_soft.basketballstat.models.Person
import ru.nvg_soft.basketballstat.presenters.PersonPresenter
import ru.nvg_soft.basketballstat.views.PersonView

class PersonFragment: MvpAppCompatFragment(), PersonView {

    @InjectPresenter
    lateinit var personPresenter: PersonPresenter

    var list = ArrayList<Person>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val myView = inflater.inflate(R.layout.fragment_persons,container,false)

        list = personPresenter.loadQuery(layoutInflater.context,"%")
        showPersonList(myView)
        val fab = myView.findViewById<View>(R.id.myFab)
        fab.setOnClickListener(){
            personPresenter.addPerson(layoutInflater.context)

        }
        return myView
    }

    override fun onResume() {
        super.onResume()
        list = personPresenter.loadQuery(layoutInflater.context,"%")
        showPersonList(view!!)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


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





}