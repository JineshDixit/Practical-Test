package com.example.practicaltest.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practicaltest.Model.PositionModel
import com.example.practicaltest.databinding.OptionitemsBinding

class OptionAdapter() : RecyclerView.Adapter<OptionAdapter.OptionHolder>() {

    var optionlist = ArrayList<PositionModel>()

    fun setPositionData(optionListData: ArrayList<PositionModel>) {
        this.optionlist = optionListData
        notifyItemRangeChanged(0, optionListData.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionHolder {
        return OptionHolder(
            OptionitemsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OptionHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return optionlist.size
    }

    inner class OptionHolder(val binding: OptionitemsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            val option = optionlist[position]
            binding.optiontxt.text = option.title
            binding.radiobtn.isChecked = option.is_active
            binding.radiobtn.setOnClickListener {
                if (option.is_active) {
                    binding.radiobtn.isChecked = false
                    option.is_active = false
                } else {
                    binding.radiobtn.isChecked = true
                    option.is_active = true
                }
            }
        }
    }
}