package com.example.f1infokotlin.objects

import kotlinx.serialization.Serializable

@Serializable
data class StandingsTable(
    val StandingsLists: List<StandingsLists>,
    val season: String
)