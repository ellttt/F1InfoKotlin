package com.example.f1infokotlin.objects.scheduleObject

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.lang.IllegalStateException
import java.time.ZonedDateTime

@Serializable
data class Race(
    @SerialName("Circuit")
    val circuit: Circuit,
    val date: String,
    @SerialName("FirstPractice")
    val firstPractice: JsonSession,
    @SerialName("Qualifying")
    val qualifying: JsonSession,
    val raceName: String,
    val round: String,
    val season: String,
    @SerialName("SecondPractice")
    val secondPractice: JsonSession,
    @SerialName("Sprint")
    val sprint: JsonSession? = null,
    @SerialName("ThirdPractice")
    val thirdPractice: JsonSession? = null,
    val time: String,
    val url: String
) {
    val raceNameShort: String
        get() = raceName.replace("Grand Prix", "GP")

    val myRaceDate: ZonedDateTime
        get() = ZonedDateTime.parse("${date}T$time");

    val sessionList: List<Session>
        get() {

            val thirdSession = thirdPractice?.let {
                Session("Third Practice", thirdPractice)
            } ?: sprint?.let {
                Session("Sprint", sprint)
            } ?: throw IllegalStateException("Missing a Session")

            return listOf(
                Session("First Practice", firstPractice),
                Session("Second Practice", secondPractice),
                Session("Qualifying", qualifying),
                Session("Race", JsonSession(date, time)),
                thirdSession,
            ).sortedBy { it.dateTime }
        }


}