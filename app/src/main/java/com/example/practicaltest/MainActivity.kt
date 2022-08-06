package com.example.practicaltest

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.practicaltest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var limit: Int = 0
    var group: Int = 0
    var option: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onClickListener()
    }

    private fun onClickListener() {
        binding.generate.setOnClickListener(View.OnClickListener {
            checkandstartActivity()
        })
    }

    private fun checkandstartActivity() {

        if (binding.editgroup.text.toString().trim() == limit.toString()) {
            val toast = Toast.makeText(this, "Group must be more then zero", Toast.LENGTH_SHORT)
            toast.show()
        } else if (binding.editoption.text.toString().trim() == limit.toString()) {
            val toast = Toast.makeText(this, "Option must be more then zero", Toast.LENGTH_SHORT)
            toast.show()
        } else if (binding.editgroup.text.toString().isEmpty()) {
            binding.editgroup.error = "Field can't be empty"
        } else if (binding.editoption.text.toString().isEmpty()) {
            binding.editoption.error = "Field can't be empty"
        } else {
            group = binding.editgroup.text.toString().toInt()
            option = binding.editoption.text.toString().toInt()
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("group", group)
            intent.putExtra("option", option)
            startActivity(intent)
        }
    }
}