package com.jsw.accfuel.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.jsw.accfuel.Model.Track

@Dao
interface TrackDao {
    @Query("SELECT * from Tracks")
    fun getTracks(): LiveData<List<Track>>

    @Insert
    fun insertTrack(track: Track)
}