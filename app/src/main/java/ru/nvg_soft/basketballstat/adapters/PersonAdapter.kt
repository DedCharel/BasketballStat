package ru.nvg_soft.basketballstat.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.person.view.*
import ru.nvg_soft.basketballstat.R
import ru.nvg_soft.basketballstat.actyvities.AddPersonActivity
import ru.nvg_soft.basketballstat.models.Person


class PersonAdapter(): RecyclerView.Adapter<PersonAdapter.ViewHolder>() {
    var items:List<Person> = listOf()

   inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
       val tvName: TextView = itemView.tvAddName
        val tvDob: TextView = itemView.tvDob


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val personView = LayoutInflater.from(parent.context).inflate(R.layout.person, parent, false)
        return ViewHolder(personView)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person = items[position]
        holder.tvName.text = person.name
        holder.tvDob.text = person.dob.toString()
        holder.tvName.setOnClickListener { goToUpdate(holder.tvDob.context, person) }

    }

    fun goToUpdate(context: Context, person: Person){
        var intent=  Intent(context,AddPersonActivity::class.java)
        intent.putExtra("ID",person.id)
        intent.putExtra("name",person.name)
        intent.putExtra("dob",person.dob.toString())
        intent.putExtra("height",person.height.toString())
        intent.putExtra("weight",person.weight.toString())
    //    intent.putExtra("image",person.image)
        context.startActivity(intent)
    }

    fun updateData(data: List<Person>) {
        val diffCallback = object: DiffUtil.Callback(){
            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                items[oldItemPosition].id == data[newItemPosition].id

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                items[oldItemPosition].hashCode() == data[newItemPosition].hashCode()

            override fun getOldListSize(): Int = items.size

            override fun getNewListSize(): Int = data.size
        }

        val diffResult = DiffUtil.calculateDiff(diffCallback)
        items = data
        diffResult.dispatchUpdatesTo(this)
    }


}