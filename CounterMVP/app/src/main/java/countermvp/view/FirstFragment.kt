package countermvp.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.crusher.countermvp.R
import com.crusher.countermvp.databinding.FragmentFirstBinding
import countermvp.contract.MainScreenContract
import countermvp.presenter.CounterPresenter

class FirstFragment : Fragment(), MainScreenContract.View {
    private lateinit var binding: FragmentFirstBinding
    private var presenter = CounterPresenter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter.attachView(this)
        initView()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    override fun initView() {
        setOnClickListeners()
        updateView()
    }

    override fun setOnClickListeners() {
        binding.incrementBtn.setOnClickListener {
            presenter.incrementCounter()
        }
        binding.decrementBtn.setOnClickListener {
            presenter.decrementCounter()
        }

        binding.goToSecondFragmentBtn.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable(COUNTER_KEY, presenter.getCounterValue())
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundle)
        }
    }

    override fun updateView() {
        Log.d("counter" , presenter.getCounterValue().toString())
        binding.counterText.text = presenter.getCounterValue().toString()
    }

    companion object {
        const val COUNTER_KEY = "COUNTER_KEY"
    }
}