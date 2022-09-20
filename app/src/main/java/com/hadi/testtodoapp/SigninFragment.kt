package com.hadi.testtodoapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.hadi.testtodoapp.databinding.FragmentSigninBinding

class SigninFragment : Fragment() {

    private var binding: FragmentSigninBinding? = null
    private val sharedViewModel: TaskViewModel by activityViewModels()

    private lateinit var  mAuth: FirebaseAuth
    private lateinit var  mUser: FirebaseUser

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentSigninBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        FirebaseApp.initializeApp(requireContext())
        mAuth = FirebaseAuth.getInstance()

        binding?.signin?.setOnClickListener {


            val email:String = binding?.email1?.getText().toString().trim()
            val password: String = binding?.password?.getText().toString().trim()

            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful)
                {
                    val intent = Intent(requireContext(),HomeActivity::class.java)
                    startActivity(intent)
                }
            }.addOnFailureListener { exception->
                val snack = Snackbar.make(it,exception.localizedMessage, Snackbar.LENGTH_LONG)
                snack.show()
            }

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