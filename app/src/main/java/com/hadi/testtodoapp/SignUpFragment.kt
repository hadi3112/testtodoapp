package com.hadi.testtodoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.hadi.testtodoapp.databinding.FragmentSignUpBinding


class SignUpFragment : Fragment() {

    private var binding: FragmentSignUpBinding? = null
    private val sharedViewModel: TaskViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View?
    {
        val fragmentBinding = FragmentSignUpBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            viewModel = sharedViewModel
            signupFragmentview = this@SignUpFragment
        }
    }

    //business logic

}