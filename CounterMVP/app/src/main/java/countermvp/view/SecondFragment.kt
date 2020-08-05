package countermvp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.crusher.countermvp.databinding.FragmentSecondBinding
import countermvp.view.FirstFragment.Companion.COUNTER_KEY
import kotlin.properties.Delegates

class SecondFragment : Fragment() {
    private var counterValue : Int? = null
    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        counterValue  = arguments?.getSerializable(COUNTER_KEY) as Int
        setDataIntoField()
    }

    private fun setDataIntoField(){
        binding.counterTextDetails.text = counterValue.toString()
    }
}