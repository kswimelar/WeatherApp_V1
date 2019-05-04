package edu.rvc.student.weatherapp_v1

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

class ForcastListAdapter(private val items: List<String>):
        RecyclerView.Adapter<ForcastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
    ViewHolder(TextView(parent.context))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = items[position]
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(val textView: TextView): RecyclerView.ViewHolder(textView)
}