package com.jsw.accfuel.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jsw.accfuel.Adapters.CarAdapter
import com.jsw.accfuel.Adapters.TrackAdapter
import com.jsw.accfuel.Model.Car
import com.jsw.accfuel.Model.Track
import com.jsw.accfuel.R
import com.jsw.accfuel.ViewModel.CarViewModel
import com.jsw.accfuel.ViewModel.TrackViewModel

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var trackVM: TrackViewModel
    private var trackAdapter = TrackAdapter()
    private lateinit var carVM: CarViewModel
    private var carAdapter = CarAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val trackRecycler = findViewById<RecyclerView>(R.id.rv_tracks)
        trackRecycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        trackRecycler.adapter = trackAdapter
        trackVM = ViewModelProviders.of(this).get(TrackViewModel::class.java)
        trackVM.getTracks().observe(this, Observer { t -> trackAdapter.setTracks(t!!) })

        val carRecycler = findViewById<RecyclerView>(R.id.rv_cars)
        carRecycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        carRecycler.adapter = carAdapter
        carVM = ViewModelProviders.of(this).get(CarViewModel::class.java)
        carVM.getCars().observe(this, Observer { t -> carAdapter.setCars(t!!) })
    }
}
