package com.example.f1infokotlin.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.f1infokotlin.apiWork.Api
import com.example.f1infokotlin.apiWork.Repository
import com.example.f1infokotlin.objects.DriverStanding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

data class MyUiState(
    val dataToDisplayOnScreen: List<DriverStanding> = emptyList(),
//    val userMessages: List<Message> = emptyList(),
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
            uiState = MyUiState(repository.getDriverStandings().MRData.StandingsTable.StandingsLists[0].DriverStandings)
        }
    }
    // Business logic
    fun somethingRelatedToBusinessLogic() { /* ... */ }
}