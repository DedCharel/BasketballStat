package ru.nvg_soft.basketballstat.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.nvg_soft.basketballstat.R
import ru.nvg_soft.basketballstat.presenters.EventPresenter
import ru.nvg_soft.basketballstat.views.EventView


class EventFragment : MvpAppCompatFragment(R.layout.fragment_events), EventView{

    private val eventPresenter by moxyPresenter { EventPresenter() }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_events, container, false)
}