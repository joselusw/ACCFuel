package com.jsw.accfuel.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.jsw.accfuel.Model.Car

@Dao
interface CarDao {
    @Query("SELECT * from Cars")
    fun getCars(): LiveData<List<Car>>

    @Insert
    fun insertCar(car: Car)
}