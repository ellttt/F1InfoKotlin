package com.example.f1infokotlin.objects.scheduleObject


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MRData(
    val limit: String,
    val offset: String,
    @SerialName("RaceTable")
    val raceTable: RaceTable,
    val series: String,
    val total: String,
    val url: String,
    val xmlns: String
)