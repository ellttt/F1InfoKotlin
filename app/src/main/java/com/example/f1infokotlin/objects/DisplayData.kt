package com.example.f1infokotlin.objects

import com.example.f1infokotlin.objects.scheduleObject.Session

data class DisplayData(
    val stats: List<String>,
    val rows: List<Session> = emptyList()
){
}
