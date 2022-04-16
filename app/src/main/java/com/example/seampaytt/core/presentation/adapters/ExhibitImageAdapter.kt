package com.example.seampaytt.core.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.seampaytt.R
import com.example.seampaytt.core.data.local.entity.ImagesEntity


class ExhibitImageAdapter(
    private val context: Context,
    private val exhibits: List<ImagesEntity>
) :
    RecyclerView.Adapter<ExhibitImageAdapter.CustomViewHolder?>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getItemCount(): Int = exhibits.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view: View = inflater.inflate(R.layout.exhibit_image_item, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val exhibit: ImagesEntity = exhibits[position]
        holder.tvChapterName.text = "exhibit"
        Glide.with(context)
            .load(exhibit.images)
            .centerInside()
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .into(holder.exhibitImage)
    }


    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var exhibitImage: ImageView = itemView.findViewById<View>(R.id.exhibitImage) as ImageView
        var tvChapterName: TextView = itemView.findViewById<View>(R.id.tvExhibitImageName) as TextView

    }

}
