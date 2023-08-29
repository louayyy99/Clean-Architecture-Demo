package com.blc.domain.sample.repository

import com.blc.domain.common.BaseResult
import com.blc.domain.sample.model.SampleModel
import kotlinx.coroutines.flow.Flow

interface SampleRepository {
    suspend fun getSamples(): Flow<BaseResult<List<SampleModel>>>
}
