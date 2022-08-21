package com.example.f1infokotlin.apiWork

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

private const val GH_BASE_URL = "https://ergast.com/api/f1"

class Api {
    private val client = HttpClient()

    suspend fun getDriverStandings(): String =
        client.get("$GH_BASE_URL/2022/driverStandings.json").body()

    suspend fun getConstructorStandings(): String =
        client.get("$GH_BASE_URL/2022/constructorStandings.json").body()

    suspend fun getSchedule():String =
        client.get("$GH_BASE_URL/current.json").body()

    suspend fun getSchoolDeptsMapFromGit(): String =
        client.get("$GH_BASE_URL/json-data/schoolDeptsMap.json").body()

}