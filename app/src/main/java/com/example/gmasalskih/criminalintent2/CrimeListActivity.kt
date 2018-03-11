package com.example.gmasalskih.criminalintent2

import android.support.v4.app.Fragment
import org.kodein.Kodein
import org.kodein.KodeinAware
import org.kodein.android.closestKodein
import org.kodein.generic.instance


class CrimeListActivity: SingleFragmentActivity(), KodeinAware {
    override val kodein: Kodein by closestKodein()
    override val fragment: Fragment by instance("CrimeListFragment")

}