package com.blc.domain.sample.usecase

import com.blc.domain.common.BaseResult
import com.blc.domain.sample.model.SampleModel
import com.blc.domain.sample.repository.SampleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSamplesUseCase @Inject constructor(private val repo: SampleRepository) {
    suspend fun invoke(): Flow<BaseResult<List<SampleModel>>> {
        return repo.getSamples()
    }
}
