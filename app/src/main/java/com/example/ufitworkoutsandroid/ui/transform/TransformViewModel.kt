package com.example.ufitworkoutsandroid.ui.transform

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TransformViewModel : ViewModel() {

    private val _texts = MutableLiveData<List<String>>().apply {
        value = listOf("uFit Workouts")
    }

    val texts: LiveData<List<String>> = _texts
}