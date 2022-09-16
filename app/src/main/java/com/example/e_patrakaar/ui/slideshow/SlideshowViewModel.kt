package com.example.e_patrakaar.ui.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SlideshowViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "About Us : \nThis is E-Patrakaar\nWe deliver you the latest news."
    }
    val text: LiveData<String> = _text
}