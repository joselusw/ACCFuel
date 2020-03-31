package com.jsw.accfuel.Database

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.jsw.accfuel.Dao.TrackDao
import com.jsw.accfuel.Model.Track
import com.jsw.accfuel.R

@Database(entities = [Track::class], version = 1)
abstract class TrackDatabase : RoomDatabase() {
    abstract fun trackDao(): TrackDao

    companion object {
        private var instance: TrackDatabase? = null

        private val romCallback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                PopulateTracksAsyncTask(instance).execute()
            }
        }

        fun getInstance(context: Context): TrackDatabase? {
            if (instance == null) {
                synchronized(TrackDatabase::class) {
                    instance = Room.databaseBuilder(
                            context.applicationContext,
                            TrackDatabase::class.java, "track_database"
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

class PopulateTracksAsyncTask(db: TrackDatabase?) : AsyncTask<Unit, Unit, Unit>() {
    private val trackDao = db?.trackDao()

    override fun doInBackground(vararg params: Unit?) {
        trackDao?.insertTrack(Track(R.drawable.barcelona, "Barcelona", "1:42.2"))
        trackDao?.insertTrack(Track(R.drawable.brands_hatch, "Brands Hatch", "1:23.310"))
        trackDao?.insertTrack(Track(R.drawable.hungaroring, "Hungaroring", "2:01.407"))
        trackDao?.insertTrack(Track(R.drawable.kyalami, "Kyalami", "2:01.407"))
        trackDao?.insertTrack(Track(R.drawable.laguna_seca, "Laguna Seca", "2:01.407"))
        trackDao?.insertTrack(Track(R.drawable.misano, "Misano", "2:01.407"))
        trackDao?.insertTrack(Track(R.drawable.monza, "Monza", "2:01.407"))
        trackDao?.insertTrack(Track(R.drawable.mount_panorama, "Mount Panorama", "2:01.407"))
        trackDao?.insertTrack(Track(R.drawable.nurburgring, "Nürburgring", "2:01.407"))
        trackDao?.insertTrack(Track(R.drawable.paul_ricard, "Paul Ricard", "2:01.407"))
        trackDao?.insertTrack(Track(R.drawable.silverstone, "Silverstone", "2:01.407"))
        trackDao?.insertTrack(Track(R.drawable.spa, "Spa Francorchamps", "2:01.407"))
        trackDao?.insertTrack(Track(R.drawable.suzuka, "Suzuka", "1.59.9"))
        trackDao?.insertTrack(Track(R.drawable.zandvoort, "Zandvoort", "2:01.407"))
        trackDao?.insertTrack(Track(R.drawable.zolder, "Zolder", "2:01.407"))
    }
}