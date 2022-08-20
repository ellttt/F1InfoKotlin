package com.example.f1infokotlin.apiWork

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

private const val GH_BASE_URL = "https://ergast.com/api/f1/2022/driverStandings.json"

class Api {
    private val client = HttpClient()

    suspend fun getDriverStandings(): String =
        client.get("$GH_BASE_URL").body()

    suspend fun getSchoolDeptsMapFromGit(): String =
        client.get("$GH_BASE_URL/json-data/schoolDeptsMap.json").body()

}