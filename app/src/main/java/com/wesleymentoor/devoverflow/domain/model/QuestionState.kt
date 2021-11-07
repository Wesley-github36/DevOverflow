package com.wesleymentoor.devoverflow.domain.model

import com.wesleymentoor.devoverflow.common.util.Status

data class QuestionState(
    val status: Status,
    val questions: List<Question> = emptyList(),
    val error: String = ""
)
