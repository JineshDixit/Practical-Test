package com.example.practicaltest.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.practicaltest.Model.GroupModel
import com.example.practicaltest.R
import com.example.practicaltest.databinding.GroupitemsBinding

class GroupAdapter(var context: Context) : RecyclerView.Adapter<GroupAdapter.GrouoViewHolder>() {

    var grouplist: ArrayList<GroupModel> = arrayListOf()
    lateinit var optionAdapter: OptionAdapter
    private var isAllAttempt = false
    var isUnchanged = true

    fun setData(groupListData: ArrayList<GroupModel>) {
        this.grouplist = groupListData
        notifyItemRangeChanged(0, (grouplist.size))
    }

    fun finish():Boolean{

        isUnchanged = false
        for (i in grouplist.indices){
            for (j in grouplist[i].arrayList.indices){
                if(grouplist[i].arrayList[j].is_active){
                   isAllAttempt = true
                   break
                }
                else{
                    isAllAttempt = false
                }
            }
            if(!isAllAttempt){
               break
            }
        }
        notifyItemRangeChanged(0,(grouplist.size))
        return  isAllAttempt
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GrouoViewHolder {
        return GrouoViewHolder(
            GroupitemsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: GrouoViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return grouplist.size
    }

    inner class GrouoViewHolder(val binding: GroupitemsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {

            val group = grouplist[position]
            binding.tvGroupName.text = group.title
            optionAdapter = OptionAdapter()
            binding.rvPosotionItem.apply {
                adapter = optionAdapter
            }
            optionAdapter.setPositionData(group.arrayList)

            if (!isUnchanged){
                for (j in group.arrayList.indices){
                    if (group.arrayList[j].is_active){
                        binding.tvGroupName.setTextColor(ContextCompat.getColor(context, R.color.black))
                        break
                    }
                    else{
                        binding.tvGroupName.setTextColor(ContextCompat.getColor(context, android.R.color.holo_red_dark))
                    }
                }
            }


        }
    }
}