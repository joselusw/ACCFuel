package com.jsw.accfuel.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.jsw.accfuel.Model.Track
import com.jsw.accfuel.Repository.TrackRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {
        private var repository: TrackRepository = TrackRepository(application)
        private var tracks: LiveData<List<Track>> = repository.getTracks()

        fun insert(track: Track) {
            repository.insert(track)
        }

        fun getTracks(): LiveData<List<Track>> {
            return tracks
        }
    }
