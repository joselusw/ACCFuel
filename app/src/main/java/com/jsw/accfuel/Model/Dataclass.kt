package com.jsw.accfuel.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cars")
data class Car(val imageID: Int, val name: String, val fuelConsumption: Double, val year: String){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}

@Entity(tableName = "tracks")
data class Track(val imageID: Int, val name: String, val lapTime: String) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}