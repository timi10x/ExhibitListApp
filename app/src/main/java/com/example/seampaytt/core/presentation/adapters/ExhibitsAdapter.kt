package com.example.seampaytt.core.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.seampaytt.R
import com.example.seampaytt.core.data.local.entity.ExhibitEntity


class ExhibitsAdapter(var exhibits: List<ExhibitEntity>, private val context: Context) :
    RecyclerView.Adapter<ExhibitsAdapter.ViewHolder?>() {

    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.recyclerView.adapter = ExhibitImageAdapter(context, exhibits[position].images!!)
        holder.recyclerView.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        holder.recyclerView.setHasFixedSize(true)
        holder.tvHeading.setText(exhibits[position].title)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var recyclerView: RecyclerView = itemView.findViewById<View>(R.id.exhibitItemRV) as RecyclerView
        var tvHeading: TextView = itemView.findViewById<View>(R.id.tvExhibitName) as TextView

    }

    override fun getItemCount(): Int = exhibits.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = layoutInflater.inflate(R.layout.single_exhibit_item, parent, false)
        return ViewHolder(view)
    }
}
