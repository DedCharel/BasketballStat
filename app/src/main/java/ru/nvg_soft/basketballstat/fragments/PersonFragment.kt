package ru.nvg_soft.basketballstat.fragments


import android.content.Context
import android.content.Intent
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_persons.*


import kotlinx.android.synthetic.main.fragment_persons.view.*
import kotlinx.android.synthetic.main.fragment_persons.view.lvPerson
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import moxy.presenter.InjectPresenter
import ru.nvg_soft.basketballstat.R
import ru.nvg_soft.basketballstat.actyvities.AddPersonActivity
import ru.nvg_soft.basketballstat.adapters.PersonAdapter
import ru.nvg_soft.basketballstat.models.Person
import ru.nvg_soft.basketballstat.presenters.PersonPresenter
import ru.nvg_soft.basketballstat.views.PersonView

class PersonFragment: MvpAppCompatFragment(R.layout.fragment_persons),PersonView {

//    @InjectPresenter
//    lateinit var personPresenter: PersonPresenter
    private val personPresenter by moxyPresenter { PersonPresenter(activity!!.application) }
  //  lateinit var model:PersonPresenter
    lateinit var personAdapter: PersonAdapter
    lateinit var myView: View



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         myView = inflater.inflate(R.layout.fragment_persons,container,false)
        initView()
        personPresenter.onStartFragment()
//        model = ViewModelProvider(this).get(PersonPresenter::class.java)
//        model.getPersonData().observe(viewLifecycleOwner, Observer { personAdapter.updateData(it) })
        myView.myFab.setOnClickListener(){
           addPerson(layoutInflater.context)
        }
        myView.btn_add.setOnClickListener {
          //  personPresenter.addPerson(Person(null,"name",1,2,3))
        }
        return myView
    }


    override fun onResume() {
        super.onResume()
     //   personPresenter.onStartFragment()
    }

     override fun showPersonList(list: List<Person>){
         val divider = DividerItemDecoration(this.activity, DividerItemDecoration.VERTICAL)
         with(lvPerson){
             adapter = personAdapter
             layoutManager = LinearLayoutManager(activity)
             addItemDecoration(divider)
         }
       }



   private fun addPerson(context:Context){
        var intent = Intent(context, AddPersonActivity::class.java)
        context.startActivity(intent)

    }
    private fun initView() {
        personAdapter = PersonAdapter()

    }







}