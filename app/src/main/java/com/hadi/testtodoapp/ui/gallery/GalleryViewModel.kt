package com.hadi.testtodoapp.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

    private val _taskname2 = MutableLiveData<String>("")
    val taskname:LiveData<String> = _taskname2


    private var _academictaskarrayLive = MutableLiveData<MutableList<String>>(null)
    val academictaskarrayLive:LiveData<MutableList<String>> = _academictaskarrayLive

    private var academictaskarray:MutableList<String> = ArrayList()    //just an empty list



    private val _details2 = MutableLiveData<String>()
    val details2: LiveData<String> = _details2

    private val _duedate2 = MutableLiveData<String>()
    val duedate2: LiveData<String> = _duedate2

    private val _remindertime2 = MutableLiveData<String>()
    val remindertime2: LiveData<String> = _remindertime2


    fun setTaskArray(task:String)
    {
        academictaskarray.add(task)
        _academictaskarrayLive.value = (academictaskarray)

    }
}