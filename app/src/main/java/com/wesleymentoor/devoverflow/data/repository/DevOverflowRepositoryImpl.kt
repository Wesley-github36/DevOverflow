package com.wesleymentoor.devoverflow.data.repository

import com.wesleymentoor.devoverflow.common.dispatcher.DispatcherProvider
import com.wesleymentoor.devoverflow.common.dispatcher.DispatcherProviderImpl
import com.wesleymentoor.devoverflow.data.remote.dto.Owner
import com.wesleymentoor.devoverflow.data.remote.dto.QuestionByIdDTO
import com.wesleymentoor.devoverflow.data.remote.dto.QuestionDto
import com.wesleymentoor.devoverflow.data.remote.dto.QuestionContainerDto
import com.wesleymentoor.devoverflow.data.remote.service.DevOverflowApi
import com.wesleymentoor.devoverflow.domain.repository.DevOverflowRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DevOverflowRepositoryImpl @Inject constructor(
    private val devOverflowApi: DevOverflowApi
) : DevOverflowRepository {

    override suspend fun getQuestions(fromDate: String, toDate: String): Flow<QuestionContainerDto> = flow {
        emit(devOverflowApi.loadAllQuestions(fromDate, toDate))
    }

    override suspend fun getQuestionById(id: Long): Flow<QuestionByIdDTO> = flow {
        emit(devOverflowApi.loadQuestionById(id))
    }

}



