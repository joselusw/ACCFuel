package com.jsw.accfuel.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jsw.accfuel.Adapters.TrackAdapter
import com.jsw.accfuel.Model.Track
import com.jsw.accfuel.R
import com.jsw.accfuel.ViewModel.MainViewModel

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var trackVM: MainViewModel
    private var trackAdapter = TrackAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val recycler = findViewById<RecyclerView>(R.id.rv_tracks)
        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recycler.adapter = trackAdapter
        trackVM = ViewModelProviders.of(this).get(MainViewModel::class.java)
        trackVM.getTracks().observe(this, Observer<List<Track>> { t -> trackAdapter.setTracks(t!!) })
    }
}
