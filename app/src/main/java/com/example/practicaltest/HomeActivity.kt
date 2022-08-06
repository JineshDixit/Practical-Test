package com.example.practicaltest

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.practicaltest.Adapter.GroupAdapter
import com.example.practicaltest.Model.GroupModel
import com.example.practicaltest.Model.PositionModel
import com.example.practicaltest.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    lateinit var groupAdapter: GroupAdapter
    var grouplist: ArrayList<GroupModel> = arrayListOf()
    var optionlist: ArrayList<PositionModel> = arrayListOf()
    var option: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val position: Int = getIntentData()
        initView()
        setDataInAdapter(position)
        onClickListner()

    }

    private fun creatRadioButtonList(number: Int): ArrayList<PositionModel> {
        optionlist = arrayListOf()
        for (i in 1..number) {
            val list = PositionModel(title = "Option $i")
            this.optionlist.add(list)
        }
        return optionlist
    }

    private fun onClickListner(){
        binding.submit.setOnClickListener {
            if (groupAdapter.finish()){
                val toast = Toast.makeText(this, "Success", Toast.LENGTH_SHORT)
                toast.show()

            }
        }
    }

    private fun getIntentData(): Int {
        val position: Int = intent.getIntExtra("group", 0)
        option = intent.getIntExtra("option", 0)
        return position
    }

    private fun setDataInAdapter(number: Int) {
        grouplist = arrayListOf()
        for (i in 1..number) {
            val list = GroupModel(arrayList = creatRadioButtonList(option), title = "Group $i")
            this.grouplist.add(list)
        }
        groupAdapter.setData(grouplist)
    }

    private fun initView() {
        groupAdapter = GroupAdapter(this)
        binding.groupRecycler.adapter = groupAdapter
    }

}