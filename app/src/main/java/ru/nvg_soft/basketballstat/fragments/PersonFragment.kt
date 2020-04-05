package ru.nvg_soft.basketballstat.fragments


import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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




    fun showPersonList(view: View){
        val  myListView: RecyclerView = view.findViewById(R.id.lvPerson)
        myListView.layoutManager = LinearLayoutManager(layoutInflater.context)
        myListView.adapter = PersonAdapter(list = list)

    }





}