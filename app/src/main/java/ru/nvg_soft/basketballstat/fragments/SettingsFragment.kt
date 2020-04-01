package ru.nvg_soft.basketballstat.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import ru.nvg_soft.basketballstat.R
import ru.nvg_soft.basketballstat.presenters.SettingsPresenter
import ru.nvg_soft.basketballstat.views.SettingsView

class SettingsFragment : Fragment(),SettingsView {
    @InjectPresenter
    lateinit var settingsPresenter: SettingsPresenter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_settings, container, false)
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}