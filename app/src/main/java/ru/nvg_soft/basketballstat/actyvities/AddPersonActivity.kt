package ru.nvg_soft.basketballstat.actyvities

import android.content.ContentValues
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.activity_add_person.*
import ru.nvg_soft.basketballstat.R
import ru.nvg_soft.basketballstat.models.DBManager
import ru.nvg_soft.basketballstat.presenters.AddPersonPresenter
import ru.nvg_soft.basketballstat.views.AddPersonView

class AddPersonActivity:MvpAppCompatActivity(),AddPersonView {

    @InjectPresenter
    lateinit var addPersonPresenter: AddPersonPresenter
    val dbTable="Person"
    var id=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_person)

        try{
            var bundle:Bundle= intent.extras!!
            id=bundle.getInt("ID",0)
            if(id!=0) {
                etName.setText(bundle.getString("name") )


            }
        }catch (ex:Exception){}
    }

    fun onClickAdd(view: View){
        var dbManager = DBManager(this)
        var values = ContentValues()
        values.put("Name", etName.text.toString())
        values.put("DOB", etDOB.text.toString())
        values.put("Weight", etWeight.text.toString())
        values.put("Height", etHeight.text.toString())

        if (id==0) {
            val ID = dbManager.Insert(values)
            if (ID > 0) {
                Toast.makeText(this, " person is added", Toast.LENGTH_LONG).show()
                finish()
            } else {
                Toast.makeText(this, " canot add person", Toast.LENGTH_LONG).show()
            }
        }else{
            var selectionArs= arrayOf(id.toString())
            val ID = dbManager.Update(values,"ID=?",selectionArs)
            if (ID > 0) {
                Toast.makeText(this, " person is added", Toast.LENGTH_LONG).show()
                finish()
            } else {
                Toast.makeText(this, " cannot add person ", Toast.LENGTH_LONG).show()
            }
        }

    }
}