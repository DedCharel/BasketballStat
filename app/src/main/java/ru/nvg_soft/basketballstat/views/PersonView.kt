package ru.nvg_soft.basketballstat.views


import moxy.MvpView
import moxy.viewstate.strategy.AddToEndStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.AddToEndSingle
import ru.nvg_soft.basketballstat.models.Person

//@StateStrategyType(value = AddToEndStrategy::class)
interface PersonView: MvpView {
    @AddToEndSingle
    fun showPersonList(list:List<Person>)
}