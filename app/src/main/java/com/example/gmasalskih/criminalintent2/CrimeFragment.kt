package com.example.gmasalskih.criminalintent2

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_crime.view.*
import org.kodein.Kodein
import org.kodein.KodeinAware
import org.kodein.android.closestKodein
import org.kodein.generic.instance

class CrimeFragment : Fragment(), KodeinAware {
    override val kodein: Kodein by closestKodein()
    private val crime: Crime by instance()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_crime, container, false)

        view.crime_title.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                crime.title = p0.toString()
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        view.crime_date.text = crime.date.toString()
        view.crime_date.isEnabled = false

        view.crime_solved.setOnCheckedChangeListener { _, isChecked -> crime.solved = isChecked }


        return view
    }
}