package com.blc.data.sample.repository

import com.blc.data.sample.remote.SampleApi
import com.blc.domain.common.BaseResult
import com.blc.domain.sample.model.SampleModel
import com.blc.domain.sample.repository.SampleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SampleRepositoryImpl @Inject constructor(private val api: SampleApi) : SampleRepository {

    override suspend fun getSamples(): Flow<BaseResult<List<SampleModel>>> = flow {
        emit(BaseResult.Loading)

        try {
            val response = api.getSamples()
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(BaseResult.Success(it))
                }
            } else {
                emit(BaseResult.Error(response.message()))
            }
        } catch (e: Exception) {
            emit(BaseResult.Error(e.message ?: "Unknown error"))
        }
    }
}
