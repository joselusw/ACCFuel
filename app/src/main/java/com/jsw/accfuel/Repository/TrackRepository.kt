package com.jsw.accfuel.Repository

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.jsw.accfuel.Dao.TrackDao
import com.jsw.accfuel.Database.TrackDatabase
import com.jsw.accfuel.Model.Track

class TrackRepository(application: Application) {
    private var trackDao: TrackDao

    private var allTracks: LiveData<List<Track>>

    init {
        val database: TrackDatabase = TrackDatabase.getInstance(
            application.applicationContext
        )!!
        trackDao = database.trackDao()
        allTracks = trackDao.getTracks()
    }


    fun getTracks(): LiveData<List<Track>> {
        return allTracks
    }

    fun insert(track: Track) {
        InsertTrackAsyncTask(trackDao).execute(track)
    }

    private class InsertTrackAsyncTask(trackDao: TrackDao) : AsyncTask<Track, Unit, Unit>() {
        val  trackDao = trackDao

        override fun doInBackground(vararg p0: Track?) {
            trackDao.insertTrack(p0[0]!!)
        }
    }
}