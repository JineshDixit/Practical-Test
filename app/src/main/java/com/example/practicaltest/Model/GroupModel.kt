package com.example.practicaltest.Model

data class GroupModel(
    var title: String = "",
    var isAttempted: Boolean = false,
    var arrayList : ArrayList<PositionModel> = arrayListOf()
    )
