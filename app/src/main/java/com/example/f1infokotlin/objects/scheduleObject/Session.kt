package com.example.f1infokotlin.objects.scheduleObject

import kotlinx.serialization.Serializable
import java.time.ZonedDateTime

@Serializable
data class Session(
    val name: String,
    private val jsonSession: JsonSession
){
    val dateTime: ZonedDateTime
        get() = ZonedDateTime.parse("${jsonSession.date}T${jsonSession.time}");
}
