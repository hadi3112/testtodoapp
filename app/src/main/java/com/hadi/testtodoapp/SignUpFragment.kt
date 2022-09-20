package com.hadi.testtodoapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import com.hadi.testtodoapp.databinding.FragmentSignUpBinding


class SignUpFragment : Fragment() {

    private var binding: FragmentSignUpBinding? = null
    private val sharedViewModel: TaskViewModel by activityViewModels()
    private lateinit var mAuth: FirebaseAuth

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View?
    {
        val fragmentBinding = FragmentSignUpBinding.inflate(inflater, container, false)
        binding = fragmentBinding


        FirebaseApp.initializeApp(requireContext())
        //get FireBaseAuth instance
        mAuth = FirebaseAuth.getInstance()

        binding?.signup?.setOnClickListener {

            binding?.progressBar?.setVisibility(View.VISIBLE)

            val email:String = binding?.email2?.getText().toString().trim()
            val password: String = binding?.password2?.getText().toString().trim()

            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task->
                if (task.isSuccessful())
                {
                    //go to sign in tab
                    val snack = Snackbar.make(it, "You're Registered!",Snackbar.LENGTH_LONG)
                    snack.show()
                    binding?.progressBar?.setVisibility(View.INVISIBLE)


                }
            }.addOnFailureListener { exception ->
                val snack = Snackbar.make(it,exception.localizedMessage,Snackbar.LENGTH_LONG)
                snack.show()
                binding?.progressBar?.setVisibility(View.INVISIBLE)
            }
        }
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