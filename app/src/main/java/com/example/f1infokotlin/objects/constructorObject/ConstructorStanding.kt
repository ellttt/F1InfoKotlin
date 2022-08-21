package com.example.f1infokotlin.objects.constructorObject


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConstructorStanding(
    @SerialName("Constructor")
    val constructor: Constructor,
    val points: String,
    val position: String,
    val positionText: String,
    val wins: String
)