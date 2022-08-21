package com.example.f1infokotlin.objects.scheduleObject


import kotlinx.serialization.Serializable

@Serializable
data class Qualifying(
    val date: String,
    val time: String
)