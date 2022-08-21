package com.example.f1infokotlin.objects.constructorObject


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MRData(
    val limit: String,
    val offset: String,
    val series: String,
    @SerialName("StandingsTable")
    val standingsTable: StandingsTable,
    val total: String,
    val url: String,
    val xmlns: String
)