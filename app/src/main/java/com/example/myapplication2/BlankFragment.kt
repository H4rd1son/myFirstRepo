package com.example.myapplication2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.myapplication2.databinding.FragmentBlankBinding

class BlankFragment : Fragment() {
    private val dataModel : DataModel by activityViewModels()
    lateinit var binding: FragmentBlankBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlankBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.messageForFrag1.observe(activity as LifecycleOwner) {
            binding.tvMessage.text = it
        }
        binding.bSendToFrag2.setOnClickListener{
            dataModel.messageForFrag2.value = "Message to fragment2 from fragment 1"
        }
        binding.bSendToActivity.setOnClickListener {
            dataModel.messageForActivity.value = "Message to activity from fragment 1"
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment()
    }
}