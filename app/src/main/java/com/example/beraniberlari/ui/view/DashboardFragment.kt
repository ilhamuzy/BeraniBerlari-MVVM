package com.example.beraniberlari.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.beraniberlari.databinding.DashboardFragmentBinding
import com.example.beraniberlari.ui.viewmodel.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private var binding: DashboardFragmentBinding? = null

    private val viewModel : DashboardViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DashboardFragmentBinding.inflate(inflater, container, false)

        context ?: return binding?.root

        binding.let { binder ->

        }
        return binding?.root

    }

}