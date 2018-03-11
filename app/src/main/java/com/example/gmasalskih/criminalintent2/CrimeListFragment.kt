package com.example.gmasalskih.criminalintent2

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_crime_list.view.*
import kotlinx.android.synthetic.main.list_item_crime.view.*
import org.kodein.Kodein
import org.kodein.KodeinAware
import org.kodein.android.closestKodein
import org.kodein.generic.instance
import org.kodein.generic.on

class CrimeListFragment: Fragment(), KodeinAware {
    override val kodein: Kodein by closestKodein()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_crime_list, container, false)
        view.crime_recycler_view.layoutManager = LinearLayoutManager(activity)
        view.crime_recycler_view.adapter = CrimeAdapter()


        return view
    }

    private inner class CrimeHolder (inflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item_crime, parent, false)){
        fun bind(crime: Crime){
            itemView.crime_title_list.text = crime.title
            itemView.crime_date_list.text = crime.date.toString()
            itemView.setOnClickListener { Toast.makeText(activity, crime.title, Toast.LENGTH_SHORT).show() }
        }
    }

    private inner class CrimeAdapter : RecyclerView.Adapter<CrimeHolder>(){
        private val crimeLab : CrimeLab by on(context=activity).instance()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeHolder {
            return CrimeHolder(LayoutInflater.from(activity), parent)
        }

        override fun onBindViewHolder(holder: CrimeHolder, position: Int) {
            holder.bind(crimeLab.crimes[position])
        }

        override fun getItemCount() = crimeLab.crimes.size

    }


}