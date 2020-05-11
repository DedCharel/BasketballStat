package ru.nvg_soft.basketballstat.views


import moxy.MvpView
import moxy.viewstate.strategy.AddToEndStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.AddToEndSingle

//@StateStrategyType(value = AddToEndStrategy::class)
interface AddPersonView: MvpView {
    @AddToEndSingle
    fun showActivity()

}