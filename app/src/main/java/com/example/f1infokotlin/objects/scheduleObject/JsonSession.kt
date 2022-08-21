package com.example.f1infokotlin.objects.scheduleObject


import kotlinx.serialization.Serializable

@Serializable
data class JsonSession(
    val date: String,
    val time: String
)
