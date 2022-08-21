package com.example.f1infokotlin.objects.constructorObject


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MasterConstructor(
    @SerialName("MRData")
    val mRData: MRData
)