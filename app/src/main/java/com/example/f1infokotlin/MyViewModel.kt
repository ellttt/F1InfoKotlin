package com.example.f1infokotlin.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.f1infokotlin.apiWork.Repository
import com.example.f1infokotlin.objects.DisplayData
import com.example.f1infokotlin.objects.DriverStanding
import com.example.f1infokotlin.objects.constructorObject.ConstructorStanding
import com.example.f1infokotlin.objects.scheduleObject.Race
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

data class MyUiState(
    val driverDataToDisplayOnScreen: List<DriverStanding> = emptyList(),
    val constructorDataToDisplayOnScreen: List<ConstructorStanding> = emptyList(),
    val scheduleDataToDisplayOnScreen: List<Race> = emptyList(),
    val loading: Boolean = false
)

class MyViewModel(
    private val coroutineScope: CoroutineScope,
    private val repository: Repository,
    private val savedState: SavedStateHandle
) : ViewModel() {

    var uiState by mutableStateOf(MyUiState())
        private set

    init {
        coroutineScope.launch {
            uiState = MyUiState(
                repository.getDriverStandings().MRData.StandingsTable.StandingsLists[0].DriverStandings,
                repository.getConstructorStandings().mRData.standingsTable.standingsLists[0].constructorStandings,
                repository.getSchedule().mRData.raceTable.races
            )
        }
    }
}

fun driverDisplay(listODriverStanding: List<DriverStanding>): List<DisplayData> {
    return listODriverStanding.map {
        DisplayData(listOf("P${it.positionText}", it.driver.familyName, it.points))
    }
}

fun constructorDisplay(listOConstructorStanding: List<ConstructorStanding>): List<DisplayData> {
    return listOConstructorStanding.map {
        DisplayData(listOf("P${it.positionText}", it.constructor.name, it.points))
    }
}

fun scheduleDisplay(listOSchedule: List<Race>): List<DisplayData> {

    return listOSchedule.map {
        DisplayData(
            listOf(
                it.round,
                it.raceNameShort,
                "${it.myRaceDate.monthValue}/${it.myRaceDate.dayOfMonth}"
            ), it.sessionList
        )

    }
}