package com.example.f1infokotlin.objects

import kotlinx.serialization.Serializable

@Serializable
data class StandingsLists(
    val DriverStandings: List<DriverStanding>,
    val round: String,
    val season: String
)