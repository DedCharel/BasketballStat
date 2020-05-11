package ru.nvg_soft.basketballstat.presenters



import android.app.Application
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.presenterScope

import ru.nvg_soft.basketballstat.models.Person
import ru.nvg_soft.basketballstat.repositories.MyRepository
import ru.nvg_soft.basketballstat.views.AddPersonView

//@InjectViewState
class AddPersonPresenter(application: Application): MvpPresenter<AddPersonView>() {
    private val repository = MyRepository.getInstance(application)
    fun startActivity(){
        viewState.showActivity()
    }

    fun addPerson(person: Person) {
        Log.d("M_AddPersonPresenter","addPerson $repository")
        presenterScope.launch { repository!!.insertPerson(person)}
        Log.d("M_AddPersonPresenter","${repository!!.getAllPerson().value.isNullOrEmpty()}")


    }

    fun updatePerson(person: Person){
        Log.d("M_AddPersonPresenter","updatePerson")
        presenterScope.launch { repository!!.updatePerson(person) }
    }
}