package com.example.f1infokotlin.objects

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DriverStanding(
    @SerialName("Constructors")
    val constructors: List<Constructor>,
    @SerialName("Driver")
    val driver: Driver,
    val points: String,
    val position: String,
    val positionText: String,
    val wins: String
)