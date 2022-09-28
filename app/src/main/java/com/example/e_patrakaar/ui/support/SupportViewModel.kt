package com.example.e_patrakaar.ui.support

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SupportViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = ("Reach us out\n"+"\n"
        + "Email: epatrakar@gmail.com\n"
        + "Contact: 99XXX XXXXX\n"
        + "Insta: e_patrakar\n"
        + "Facebook: E_patrakar\n")
    }
    val text: LiveData<String> = _text
}