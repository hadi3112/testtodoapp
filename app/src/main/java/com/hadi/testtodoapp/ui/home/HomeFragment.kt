package com.hadi.testtodoapp.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.hadi.testtodoapp.TaskListAdapter
import com.hadi.testtodoapp.TaskViewModel
import com.hadi.testtodoapp.databinding.FragmentHomeBinding
import java.util.*

class HomeFragment : Fragment() , HomeFabDialogue.TaskNameListener{

    private var binding: FragmentHomeBinding? = null
    private val sharedViewModel:TaskViewModel by activityViewModels()

    private var mydataset = listOf<String>()

    // This property is only valid between onCreateView and
    // onDestroyView.


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View
    {
        val fragmentbinding = FragmentHomeBinding.inflate(inflater, container, false)
        binding = fragmentbinding

        HomeFabDialogue().setlistener(this)

        Log.v("TAG","Fragment created")

        return fragmentbinding.root
    }

    private  fun initObserver(){
        sharedViewModel.hometaskarrayLive.observe(viewLifecycleOwner ){
            it.let{
                if (!it.isNullOrEmpty()){
                    mydataset= it
                    initAdapter(it)
                }
            }
        }
    }

    private fun initAdapter(list: List<String>)
    {

        //val mydataset = listOf("ABCD", "EFGH")
        val myadapter = TaskListAdapter(list)

        binding?.homeRecycler?.layoutManager = LinearLayoutManager(requireActivity())
        binding?.lifecycleOwner = this
        binding?.homeRecycler?.adapter = myadapter
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {

            viewModel = sharedViewModel
            homefragment = this@HomeFragment
        }
    }

    override fun onResume() {
        super.onResume()
         initObserver()
        Log.e("taggg-listener" , "listener.toString()")
        HomeFabDialogue().setlistener(this)

    }

    override fun onFinishHomeDialog(string: String) {
        mydataset.plus(string)
        Log.e("Taggg", string)
    }


}