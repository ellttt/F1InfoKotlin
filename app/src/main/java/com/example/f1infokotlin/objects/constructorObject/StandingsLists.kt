package com.example.f1infokotlin.objects.constructorObject


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StandingsLists(
    @SerialName("ConstructorStandings")
    val constructorStandings: List<ConstructorStanding>,
    val round: String,
    val season: String
)