package com.wesleymentoor.devoverflow.domain.repository

import com.wesleymentoor.devoverflow.data.remote.dto.QuestionByIdDTO
import com.wesleymentoor.devoverflow.data.remote.dto.QuestionContainerDto
import kotlinx.coroutines.flow.Flow

interface DevOverflowRepository {

    suspend fun getQuestions(fromDate: String, toDate: String): Flow<QuestionContainerDto>

    suspend fun getQuestionById(id: Long): Flow<QuestionByIdDTO>

}