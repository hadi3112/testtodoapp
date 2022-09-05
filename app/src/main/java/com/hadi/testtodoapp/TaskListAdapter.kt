package com.hadi.testtodoapp

import android.content.Context
import android.util.Log
import android.view.LayoutInflater

import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.hadi.testtodoapp.databinding.ListItemCardBinding


class TaskListAdapter(private val dataSet:List<String>)
    : RecyclerView.Adapter<TaskListAdapter.ItemViewHolder>()

{

    class ItemViewHolder(private var binding: ListItemCardBinding):RecyclerView.ViewHolder(binding.root)
    {
        fun bind(item:String)
        {
            binding.itemcheckbox.text = item
        }

        //
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        Log.v("TAG_REC ", "CreateViewHolderCalled")
        return ItemViewHolder(ListItemCardBinding
                  .inflate(LayoutInflater
                .from(parent.context)))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataSet[position]
        Log.v("TAG: ", "value in dataset = " + dataSet[position] + " at postion " + position)
        holder.bind(item)

    }

    override fun getItemCount(): Int {
        return dataSet.size
    }


}