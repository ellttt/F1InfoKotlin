package com.example.f1infokotlin.objects.scheduleObject


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MasterSchedule(
    @SerialName("MRData")
    val mRData: MRData
)