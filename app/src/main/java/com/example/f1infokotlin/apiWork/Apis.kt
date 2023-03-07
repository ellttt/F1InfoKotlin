package com.example.f1infokotlin.apiWork

import com.example.f1infokotlin.YEAR_FOR_DATA
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

private const val GH_BASE_URL = "https://ergast.com/api/f1"

class Api {
    private val client = HttpClient()

    suspend fun getDriverStandings(): String =
        client.get("$GH_BASE_URL/$YEAR_FOR_DATA/driverStandings.json").body()

    suspend fun getConstructorStandings(): String =
        client.get("$GH_BASE_URL/$YEAR_FOR_DATA/constructorStandings.json").body()

    suspend fun getSchedule():String =
        client.get("$GH_BASE_URL/current.json").body()

    suspend fun getSchoolDeptsMapFromGit(): String =
        client.get("$GH_BASE_URL/json-data/schoolDeptsMap.json").body()

}