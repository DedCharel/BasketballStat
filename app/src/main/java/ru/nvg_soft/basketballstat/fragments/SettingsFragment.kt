package ru.nvg_soft.basketballstat.fragments

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import moxy.presenter.InjectPresenter
import ru.nvg_soft.basketballstat.R
import ru.nvg_soft.basketballstat.presenters.SettingsPresenter
import ru.nvg_soft.basketballstat.views.SettingsView

class SettingsFragment : MvpAppCompatFragment(R.layout.fragment_settings),SettingsView {
//    @InjectPresenter
//    lateinit var settingsPresenter: SettingsPresenter
    private val settingsPresenter by moxyPresenter { SettingsPresenter() }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_settings, container, false)
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}