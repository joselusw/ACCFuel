package com.jsw.accfuel.Database

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.jsw.accfuel.Dao.CarDao
import com.jsw.accfuel.Model.Car
import com.jsw.accfuel.R

@Database(entities = [Car::class], version = 1)
abstract class CarDatabase : RoomDatabase() {
    abstract fun CarDao(): CarDao

    companion object {
        private var instance: CarDatabase? = null

        private val romCallback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                PopulateCarsAsyncTask(instance).execute()
            }
        }

        fun getInstance(context: Context): CarDatabase? {
            if (instance == null) {
                synchronized(CarDatabase::class) {
                    instance = Room.databaseBuilder(
                            context.applicationContext,
                            CarDatabase::class.java, "Car_database"
                        )
                        .fallbackToDestructiveMigration()
                        .addCallback(romCallback)
                        .build()
                }
            }
            return instance
        }

        fun destroyInstance() {instance = null}
    }
}

class PopulateCarsAsyncTask(db: CarDatabase?) : AsyncTask<Unit, Unit, Unit>() {
    private val CarDao = db?.CarDao()

    override fun doInBackground(vararg params: Unit?) {
        CarDao?.insertCar(Car(R.drawable.amr_2019, "AMR V8 Vantage GT3", 1.30, "2019"))
        CarDao?.insertCar(Car(R.drawable.audi_2019, "Audi R8 LMS Evo", 1.31, "2019"))
        CarDao?.insertCar(Car(R.drawable.bentley_2019, "Bentley Continental GT3", 1.32, "2019"))
        CarDao?.insertCar(Car(R.drawable.bmw_2019, "BMW M6 GT3", 1.32, "2019"))
        CarDao?.insertCar(Car(R.drawable.ferrari_2019, "Ferrari 488 GT3", 1.32, "2019"))
        CarDao?.insertCar(Car(R.drawable.honda_2019, "Honda NSX GT3 Evo", 1.32, "2019"))
        CarDao?.insertCar(Car(R.drawable.lambo_evo_2019, "Lamborghini Huracan Evo", 1.32, "2019"))
        CarDao?.insertCar(Car(R.drawable.lambo_2019, "Lamborghini Huracan GT3", 1.32, "2019"))
        CarDao?.insertCar(Car(R.drawable.lexus_2019, "Lexus RC F GT3", 1.32, "2019"))
        CarDao?.insertCar(Car(R.drawable.mclaren_2019, "McLaren 720S GT3", 1.32, "2019"))
        CarDao?.insertCar(Car(R.drawable.mercedes_2019, "Mercedes-AMG GT3", 1.32, "2019"))
        CarDao?.insertCar(Car(R.drawable.nissan_2019, "Nissan GT-R Nismo GT3", 1.32, "2019"))
        CarDao?.insertCar(Car(R.drawable.porsche_2019, "Porsche 991II GT3 R", 1.32, "2019"))
    }
}