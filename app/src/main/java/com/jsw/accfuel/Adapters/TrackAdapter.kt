package com.jsw.accfuel.Adapters

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jsw.accfuel.Model.Track
import com.jsw.accfuel.R
import java.lang.reflect.Array

class TrackAdapter : RecyclerView.Adapter<TrackAdapter.TrackHolder>() {

    private var tracks: List<Track> = ArrayList()
    private var context: Context? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackHolder {
        this.context = parent.context
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.track_layout, parent, false)
        return TrackHolder(itemView)
    }

    override fun getItemCount(): Int {
        return tracks.size
    }

    override fun onBindViewHolder(holder: TrackHolder, position: Int) {
        val currentTrack = tracks[position]
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            holder.image.setImageDrawable(context?.getDrawable(currentTrack.imageID))
        }
        holder.name.text = currentTrack.name
        holder.time.text = currentTrack.lapTime.toString()
    }

    fun setTracks(tracks: List<Track>) {
        this.tracks = tracks
        notifyDataSetChanged()
    }

    inner class TrackHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var image: ImageView = itemView.findViewById(R.id.iv_track)
        var name: TextView = itemView.findViewById(R.id.tv_track)
        var time: TextView = itemView.findViewById(R.id.tv_time)
    }
}