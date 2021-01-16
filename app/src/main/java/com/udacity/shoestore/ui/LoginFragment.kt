package com.udacity.shoestore.ui

import android.os.Bundle
import android.text.TextWatcher
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.login.setOnClickListener {
            if (validInputs())
                navigateToWelcomeScreen(it)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun navigateToWelcomeScreen(view: View) {
        view.findNavController()
            .navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
    }

    private fun validInputs(): Boolean {
        if(!binding.username.text.toString().contains("@") && !Patterns.EMAIL_ADDRESS.matcher(binding.username.text.toString()).matches()){
            binding.username.error = getString(R.string.invalid_username)
            return false
        }

        if(binding.password.toString().length < 5){
            binding.password.error = getString(R.string.invalid_password)
            return false
        }
        return true
    }


}