package com.hadi.testtodoapp.ui.home

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.hadi.testtodoapp.R
import com.hadi.testtodoapp.TaskViewModel
import com.hadi.testtodoapp.databinding.TaskDialogBinding

class HomeFabDialogue:DialogFragment() {

    private val sharedViewModel: TaskViewModel by activityViewModels()
    private lateinit  var binding: TaskDialogBinding
    var listener: TaskNameListener? = null


    public interface TaskNameListener{
        fun onFinishHomeDialog(string:String)
    }



    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.80).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.60).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog!!.window?.setLayout(height, ViewGroup.LayoutParams.WRAP_CONTENT)

        binding.apply {
            viewModel = sharedViewModel
            taskdialogfragment = this@HomeFabDialogue
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val fragmentbinding = TaskDialogBinding.inflate(inflater, container, false)
        binding = fragmentbinding

        binding.donebtn.setOnClickListener {
            val text = binding.thetask.text.toString()
            sharedViewModel.setTaskArray(text)    //get Task title to be passed to recyclerview

            Log.e("taggg-listener" , listener.toString())

            dialog!!.dismiss()

        }

        binding.cancelbtn.setOnClickListener {
            dialog?.cancel()
        }

        return binding.root

    }


    public fun setlistener(listener: TaskNameListener)
    {
        this.listener = listener
    }



}