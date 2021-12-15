package com.example.beraniberlari.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.beraniberlari.R
import com.example.beraniberlari.databinding.SetupFragmentBinding
import com.example.beraniberlari.ui.viewmodel.SettingViewModel


class SetupFragment : Fragment() {

    private var binding : SetupFragmentBinding? = null

    private val viewModel : SettingViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SetupFragmentBinding.inflate(inflater,container,false)
        context ?: return binding?.root

        binding.let { binder ->

        }


        return binding?.root
    }


}