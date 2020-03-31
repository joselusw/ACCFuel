package com.jsw.accfuel.Adapters

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jsw.accfuel.Model.Car
import com.jsw.accfuel.R

class CarAdapter : RecyclerView.Adapter<CarAdapter.CarHolder>() {

    private var Cars: List<Car> = ArrayList()
    private var context: Context? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarHolder {
        this.context = parent.context
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.track_layout, parent, false)
        return CarHolder(itemView)
    }

    override fun getItemCount(): Int {
        return Cars.size
    }

    override fun onBindViewHolder(holder: CarHolder, position: Int) {
        val currentCar = Cars[position]
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            holder.image.setImageDrawable(context?.getDrawable(currentCar.imageID))
        }
        holder.image.scaleType = ImageView.ScaleType.CENTER_CROP
        holder.name.text = currentCar.name
        holder.time.text = currentCar.fuelConsumption.toString()
    }

    fun setCars(Cars: List<Car>) {
        this.Cars = Cars
        notifyDataSetChanged()
    }

    inner class CarHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var image: ImageView = itemView.findViewById(R.id.iv_track)
        var name: TextView = itemView.findViewById(R.id.tv_track)
        var time: TextView = itemView.findViewById(R.id.tv_time)
    }
}