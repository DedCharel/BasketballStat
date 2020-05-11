package ru.nvg_soft.basketballstat.presenters


import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.presenterScope
import ru.nvg_soft.basketballstat.models.Person
import ru.nvg_soft.basketballstat.repositories.MyRepository
import ru.nvg_soft.basketballstat.views.PersonView

//@InjectViewState
class PersonPresenter(application: Application): MvpPresenter<PersonView>() {
    private val repository = MyRepository.getInstance(application)
    private val personList = repository!!.getAllPerson()


    fun onStartFragment(){

        if (personList.value.isNullOrEmpty()){
            Log.d("M_PersonPresenter","list empty $repository")

        }else{
            Log.d("M_PersonPresenter","showPerson")
        viewState.showPersonList(personList.value!!)}
    }


    fun addPerson(person: Person) {
        repository!!.insertPerson1(person)
        Log.d("M_PersonPresenter","insertperson1")
    }

    fun getPersonData():LiveData<List<Person>> {
        return personList
    }

}
