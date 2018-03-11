package com.example.gmasalskih.criminalintent2

import android.app.Application
import android.support.v4.app.Fragment
import org.kodein.Kodein
import org.kodein.KodeinAware
import org.kodein.android.activityRetainedScope
import org.kodein.generic.bind
import org.kodein.generic.provider
import org.kodein.generic.scoped
import org.kodein.generic.singleton

class App : Application(), KodeinAware {
    override val kodein by Kodein.lazy {
        bind<String>() with provider { "aaaa" }
        bind<Crime>() with provider { Crime() }
        bind<Fragment>("CrimeFragment") with singleton { CrimeFragment() as Fragment }
        bind<Fragment>("CrimeListFragment") with singleton { CrimeListFragment() as Fragment }
        bind<CrimeLab>() with scoped(activityRetainedScope).singleton { CrimeLab(context) }
    }
}