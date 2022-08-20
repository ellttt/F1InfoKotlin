package com.example.f1infokotlin.apiWork

import com.example.f1infokotlin.objects.DriverStanding
import com.example.f1infokotlin.objects.DriverStandings
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

private const val GH_BASE_URL = "https://ergast.com/api/f1/2022/driverStandings.json"

class Repository {
    private val client = HttpClient()
    private val api = Api()

    suspend fun getDriverStandings(): DriverStandings =
        Json.decodeFromString(api.getDriverStandings())


    suspend fun getSchoolDeptsMapFromGit(): String =
        client.get("$GH_BASE_URL/json-data/schoolDeptsMap.json").body()

}