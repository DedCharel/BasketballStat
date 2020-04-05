package ru.nvg_soft.basketballstat.adapters

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.nvg_soft.basketballstat.R
import ru.nvg_soft.basketballstat.actyvities.AddPersonActivity
import ru.nvg_soft.basketballstat.models.Person


class PersonAdapter(private val list: List<Person>): RecyclerView.Adapter<PersonAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tvAddName)
        val tvDob: TextView = view.findViewById(R.id.tvDob)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val personView = LayoutInflater.from(parent.context).inflate(R.layout.person, parent, false)
        return ViewHolder(personView)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person = list[position]
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
        context.startActivity(intent)
    }
}