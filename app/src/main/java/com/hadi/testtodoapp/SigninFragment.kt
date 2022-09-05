package com.hadi.testtodoapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.hadi.testtodoapp.databinding.FragmentSigninBinding

class SigninFragment : Fragment() {

    private var binding: FragmentSigninBinding? = null
    private val sharedViewModel: TaskViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentSigninBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        binding?.signin?.setOnClickListener {
            val intent = Intent(requireContext(),HomeActivity::class.java)
            startActivity(intent)
        }
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            viewModel = sharedViewModel
            signinFragmentview = this@SigninFragment
        }
    }

}