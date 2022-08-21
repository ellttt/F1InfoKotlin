package com.example.f1infokotlin.objects.scheduleObject


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RaceTable(
    @SerialName("Races")
    val races: List<Race>,
    val season: String
)