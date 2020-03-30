package com.jsw.accfuel.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class Car(val imageID: Int, val name: String, val fuelConsumption: Double)

@Entity(tableName = "tracks")
data class Track(val imageID: Int, val name: String, val lapTime: Double) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}