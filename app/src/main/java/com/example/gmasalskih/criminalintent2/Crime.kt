package com.example.gmasalskih.criminalintent2

import java.util.*


data class Crime(
        val id: UUID = UUID.randomUUID(),
        var title: String = "",
        val date: Date = Date(),
        var solved: Boolean = false
)