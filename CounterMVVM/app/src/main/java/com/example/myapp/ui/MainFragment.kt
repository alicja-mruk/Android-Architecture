package com.example.myapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.myapp.R
import com.example.myapp.viewmodel.CounterViewModel
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {
    lateinit var viewModel: CounterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activity?.let {
            viewModel = ViewModelProvider(it).get(CounterViewModel::class.java)
        }

        viewModel.counter.observe(viewLifecycleOwner, Observer {
            counter_text.text = it.toString()
        })

        setOnClickListeners()
    }

    private fun setOnClickListeners(){
        increment_btn.setOnClickListener {
            viewModel.incrementCounter()
        }

        decrement_btn.setOnClickListener {
            viewModel.decrementCounter()
        }

        go_to_second_fragment_btn.setOnClickListener {
            val bundle = bundleOf("counter" to counter_text.text.toString())
            findNavController().navigate(R.id.action_mainFragment_to_counterDisplayFragment, bundle)
        }
    }

}



