package com.example.beraniberlari.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.beraniberlari.databinding.RunFragmentBinding
import com.example.beraniberlari.ui.viewmodel.RunViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RunFragment : Fragment() {

    private var binding: RunFragmentBinding? = null

    private val viewModel : RunViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = RunFragmentBinding.inflate(inflater, container, false)

        context ?: return binding?.root

        binding.let { binder ->

        }

        return binding?.root

    }


}