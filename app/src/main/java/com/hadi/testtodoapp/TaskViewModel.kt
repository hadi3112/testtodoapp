package com.hadi.testtodoapp


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class TaskViewModel : ViewModel() {


    private val _taskname = MutableLiveData<String>("")
    val taskname:LiveData<String> = _taskname


    private var _hometaskarrayLive = MutableLiveData<MutableList<String>>(null)
    val hometaskarrayLive:LiveData<MutableList<String>> = _hometaskarrayLive

    private var hometaskarray:MutableList<String> = ArrayList()    //just an empty list



    private val _details = MutableLiveData<String>()
    val details: LiveData<String> = _details

    private val _duedate = MutableLiveData<String>()
    val duedate: LiveData<String> = _duedate

    private val _remindertime = MutableLiveData<String>()
    val remindertime: LiveData<String> = _remindertime


    fun setTaskArray(task:String)
    {
        hometaskarray.add(task)
        _hometaskarrayLive.value = (hometaskarray)

    }

    fun getTaskArray(): List<String>
    {
        return hometaskarray
    }

    fun setDate(date:String)
    {
        _duedate.value = date
    }
}