package com.example.f1infokotlin.objects.constructorObject


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StandingsTable(
    val season: String,
    @SerialName("StandingsLists")
    val standingsLists: List<StandingsLists>
)