package com.example.e_patrakaar.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = ("\t"+"Privacy Policy\n" + "\n" +
                "The privacy policy is to inform you regarding the processing of your personal information which is collected during your visit to our website/ mobile application.")
    }
    val text: LiveData<String> = _text
}