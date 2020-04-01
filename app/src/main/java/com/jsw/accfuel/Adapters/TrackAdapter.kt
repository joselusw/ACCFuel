package com.jsw.accfuel.Adapters

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jsw.accfuel.Model.Track
import com.jsw.accfuel.R

class TrackAdapter : RecyclerView.Adapter<TrackAdapter.TrackHolder>() {
    private var selectedItem: Int = 0
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

        // Here I am just highlighting the background
        if (selectedItem.equals(position))
            holder.itemView.setBackgroundColor(holder.itemView.context.resources.getColor(R.color.colorAccentLight))
        else
            holder.itemView.setBackgroundColor(holder.itemView.context.resources.getColor(R.color.colorPrimary))
    }

    fun setTracks(tracks: List<Track>) {
        this.tracks = tracks
        notifyDataSetChanged()
    }

    inner class TrackHolder(itemView: View) : RecyclerView.ViewHolder(itemView), OnClickListener{
        var image: ImageView = itemView.findViewById(R.id.iv_track)
        var name: TextView = itemView.findViewById(R.id.tv_track)
        var time: TextView = itemView.findViewById(R.id.tv_time)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            if (getAdapterPosition() == RecyclerView.NO_POSITION)
                return

            // Updating old as well as new positions
            notifyItemChanged(selectedItem);
            selectedItem = getAdapterPosition();
            notifyItemChanged(selectedItem);
        }
    }
}