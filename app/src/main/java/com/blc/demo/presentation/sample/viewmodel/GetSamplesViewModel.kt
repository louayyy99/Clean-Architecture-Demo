package com.blc.demo.presentation.sample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blc.domain.common.BaseResult
import com.blc.domain.sample.model.SampleModel
import com.blc.domain.sample.usecase.GetSamplesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@HiltViewModel
class GetSamplesViewModel @Inject constructor(
    private val getSamplesUseCase: GetSamplesUseCase
) : ViewModel() {

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    private val _result = MutableStateFlow<BaseResult<List<SampleModel>>>(BaseResult.Loading)
    val result: StateFlow<BaseResult<List<SampleModel>>> = _result

    /**
     * YOU CAN USE THIS INIT BLOCK TO CALL A FUNCTION ONCE THE VIEWMODEL IS CREATED
     */
    /*init {
        getSamples()
    }*/

    fun getSamples() = viewModelScope.launch {
        _loading.value = true
        getSamplesUseCase.invoke().collectLatest {
            when (it) {
                is BaseResult.Error -> {
                    _result.value = it
                    _loading.value = false
                }

                BaseResult.Loading -> {}

                is BaseResult.Success -> {
                    _result.value = it
                    _loading.value = false
                }
            }
        }
    }
}
