package com.example.f1infokotlin.objects.constructorObject


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Constructor(
    val constructorId: String,
    val name: String,
    val nationality: String,
    val url: String
)