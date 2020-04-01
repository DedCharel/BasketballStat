package ru.nvg_soft.basketballstat.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_events.*
import ru.nvg_soft.basketballstat.models.DBManager
import ru.nvg_soft.basketballstat.models.Person
import ru.nvg_soft.basketballstat.adapters.PersonAdapter
import ru.nvg_soft.basketballstat.R
import ru.nvg_soft.basketballstat.presenters.EventPresenter
import ru.nvg_soft.basketballstat.views.EventView

class EventFragment : MvpAppCompatFragment(),EventView {

    @InjectPresenter
    lateinit var eventPresenter: EventPresenter

    val list = ArrayList<Person>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_events, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }


}