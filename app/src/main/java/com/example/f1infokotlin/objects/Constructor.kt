package com.example.f1infokotlin.objects

import kotlinx.serialization.Serializable

@Serializable
data class Constructor(
    val constructorId: String,
    val name: String,
    val nationality: String,
    val url: String
)