package com.blc.domain.common

sealed class BaseResult<out T : Any> {
    data class Success<T : Any>(val data: T) : BaseResult<T>()
    data class Error(val error: String) : BaseResult<Nothing>()
    object Loading : BaseResult<Nothing>()
}
