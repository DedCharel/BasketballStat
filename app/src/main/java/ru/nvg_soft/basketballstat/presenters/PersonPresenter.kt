package ru.nvg_soft.basketballstat.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import ru.nvg_soft.basketballstat.models.Person
import ru.nvg_soft.basketballstat.views.PersonView

@InjectViewState
class PersonPresenter:MvpPresenter<PersonView>() {

    fun loadPersonList():ArrayList<Person>{

        val list = ArrayList<Person>()
        list.add(Person("Иванов Иван"))
        list.add(Person("Петров Петр"))
        list.add(Person("Сергеев Сергей"))
        list.add(Person("Иванов Иван"))
        list.add(Person("Петров Петр"))
        list.add(Person("Сергеев Сергей"))
        list.add(Person("Иванов Иван"))
        list.add(Person("Петров Петр"))
        list.add(Person("Сергеев Сергей"))
        list.add(Person("Иванов Иван"))
        list.add(Person("Петров Петр"))
        list.add(Person("Сергеев Сергей"))
        list.add(Person("Иванов Иван"))
        list.add(Person("Петров Петр"))
        list.add(Person("Сергеев Сергей"))
        return list
    }
}