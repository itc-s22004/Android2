package jp.ac.it_college.std.s22004.navigationsample.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import jp.ac.it_college.std.s22004.navigationsample.R
import jp.ac.it_college.std.s22004.navigationsample.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button2.setOnClickListener {toNext(1)}
        binding.button3.setOnClickListener {toNext(2)}
        binding.button4.setOnClickListener {toNext(3)}
        binding.button5.setOnClickListener {toNext(4)}
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    private fun toNext(choise: Int) {
        val bundle = bundleOf("choise" to choise)
        findNavController().navigate(R.id.action_secondFragment_to_threadFragment, bundle)
    }
}