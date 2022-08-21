package com.example.f1infokotlin.objects.scheduleObject


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Circuit(
    val circuitId: String,
    val circuitName: String,
    @SerialName("Location")
    val location: Location,
    val url: String
)