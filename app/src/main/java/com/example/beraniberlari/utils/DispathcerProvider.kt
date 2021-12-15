package com.example.beraniberlari.utils

import kotlinx.coroutines.CoroutineDispatcher

interface DispathcerProvider{
    val main : CoroutineDispatcher
    val io : CoroutineDispatcher
    val default : CoroutineDispatcher
    val unconfined : CoroutineDispatcher
}