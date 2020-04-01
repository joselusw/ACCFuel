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

@Database(entities = [Track::class], version = 2)
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
        trackDao?.insertTrack(Track(R.drawable.barcelona, "Barcelona", "1:46.714"))
        trackDao?.insertTrack(Track(R.drawable.brands_hatch, "Brands Hatch", "1:24.317"))
        trackDao?.insertTrack(Track(R.drawable.hungaroring, "Hungaroring", "1:44.163"))
        trackDao?.insertTrack(Track(R.drawable.kyalami, "Kyalami", "1:42.876"))
        trackDao?.insertTrack(Track(R.drawable.laguna_seca, "Laguna Seca", "1:24.632"))
        trackDao?.insertTrack(Track(R.drawable.misano, "Misano", "1:34.165"))
        trackDao?.insertTrack(Track(R.drawable.monza, "Monza", "1:58.293"))
        trackDao?.insertTrack(Track(R.drawable.mount_panorama, "Mount Panorama", "2:04.306"))
        trackDao?.insertTrack(Track(R.drawable.nurburgring, "Nürburgring", "1:56.961"))
        trackDao?.insertTrack(Track(R.drawable.paul_ricard, "Paul Ricard", "1:53.926"))
        trackDao?.insertTrack(Track(R.drawable.silverstone, "Silverstone", "2:00.746"))
        trackDao?.insertTrack(Track(R.drawable.spa, "Spa Francorchamps", "2:20.994"))
        trackDao?.insertTrack(Track(R.drawable.suzuka, "Suzuka", "2:02.765"))
        trackDao?.insertTrack(Track(R.drawable.zandvoort, "Zandvoort", "1:37.945"))
        trackDao?.insertTrack(Track(R.drawable.zolder, "Zolder", "1:31.081"))
    }
}