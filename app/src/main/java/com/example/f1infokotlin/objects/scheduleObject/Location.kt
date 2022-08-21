package com.example.f1infokotlin.objects.scheduleObject


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val country: String,
    val lat: String,
    val locality: String,
    val long: String
)