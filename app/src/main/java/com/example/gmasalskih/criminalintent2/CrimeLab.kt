package com.example.gmasalskih.criminalintent2

import android.content.Context
import org.kodein.Kodein
import org.kodein.KodeinAware
import org.kodein.android.closestKodein
import org.kodein.generic.instance
import java.util.*

class CrimeLab(context: Context) : KodeinAware {
    override val kodein: Kodein by closestKodein(context)
    val crimes = List(100, {
        val crime: Crime by instance()
        crime.title = "Crime #$it"
        crime.solved = it % 2 == 0
        crime
    })

    fun getCrime(id: UUID) = crimes.first { it.id == id }

}