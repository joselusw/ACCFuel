package com.jsw.accfuel.Repository

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.jsw.accfuel.Dao.CarDao
import com.jsw.accfuel.Database.CarDatabase
import com.jsw.accfuel.Model.Car

class CarRepository(application: Application) {
    private var carDao: CarDao

    private var allCars: LiveData<List<Car>>

    init {
        val database: CarDatabase = CarDatabase.getInstance(
            application.applicationContext
        )!!
        carDao = database.CarDao()
        allCars = carDao.getCars()
    }


    fun getCars(): LiveData<List<Car>> {
        return allCars
    }

    fun insert(Car: Car) {
        InsertCarAsyncTask(carDao).execute(Car)
    }

    private class InsertCarAsyncTask(CarDao: CarDao) : AsyncTask<Car, Unit, Unit>() {
        val  CarDao = CarDao

        override fun doInBackground(vararg p0: Car?) {
            CarDao.insertCar(p0[0]!!)
        }
    }
}