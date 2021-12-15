package com.example.beraniberlari.ui.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.beraniberlari.R
import com.example.beraniberlari.databinding.TrackingFragmentBinding
import com.example.beraniberlari.ui.viewmodel.TrackingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrackingFragment : Fragment() {

    private var binding : TrackingFragmentBinding? = null

    private val viewModel: TrackingViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TrackingFragmentBinding.inflate(inflater, container,false)
        context ?: return binding?.root

        binding.let { binder ->


        }

        return binding?.root
    }

}