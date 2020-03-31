package com.jsw.accfuel.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.jsw.accfuel.Model.Car
import com.jsw.accfuel.Repository.CarRepository

class CarViewModel(application: Application) : AndroidViewModel(application) {
    private var repository: CarRepository = CarRepository(application)
    private var Cars: LiveData<List<Car>> = repository.getCars()

    fun getCars(): LiveData<List<Car>> {
        return Cars
    }
}