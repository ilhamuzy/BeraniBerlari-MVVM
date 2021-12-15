package com.example.beraniberlari.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.beraniberlari.data.repository.MainRepository
import com.example.beraniberlari.utils.DispathcerProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository,
    private val dispatchers: DispathcerProvider
) : ViewModel(){



}