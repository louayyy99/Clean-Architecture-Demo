package com.blc.demo.presentation.sample.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.blc.demo.presentation.sample.viewmodel.GetSamplesViewModel
import com.blc.domain.common.BaseResult
import timber.log.Timber

@Composable
fun SampleScreen() {
    Text("Hello Sample Screen!")
}

/**
 * This is a sample screen with view model
 */
@Composable
fun SampleScreenVM(viewModel: GetSamplesViewModel = hiltViewModel()) {
    // Handle loading state
    val loading = viewModel.loading.collectAsState()
    if (loading.value) {
        // Show loading
        Timber.tag("SampleScreenVM").d("Loading")
    }

    // Handle request state
    val request = viewModel.result.collectAsState()
    LaunchedEffect(request.value) {
        when (request.value) {
            is BaseResult.Error -> {}
            BaseResult.Loading -> {}
            is BaseResult.Success -> {}
        }
    }
}
