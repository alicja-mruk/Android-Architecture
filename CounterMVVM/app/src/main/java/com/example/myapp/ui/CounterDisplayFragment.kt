package com.example.myapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapp.databinding.FragmentCounterDisplayBinding

class CounterDisplayFragment : Fragment() {
    private lateinit var binding: FragmentCounterDisplayBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCounterDisplayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

       binding.counterTextDetails.text = arguments?.getString("counter")

        binding.goBackBtn.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}