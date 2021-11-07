package com.wesleymentoor.devoverflow.data.remote.dto

import com.wesleymentoor.devoverflow.domain.model.Question


//@JsonClass(generateAdapter = true)
data class QuestionContainerDto(
    val questions: List<QuestionDto>,
    val has_more: Boolean
)

/**
 * Convert Network results to domain objects
 */
fun QuestionContainerDto.asDomainModel(): List<Question> {
    return questions.map {
        Question(
            tags = it.tags,
            owner = it.owner,
            is_answered = it.is_answered,
            view_count = it.view_count,
            answer_count = it.answer_count,
            score = it.score,
            question_id = it.question_id,
            link = it.link,
            title = it.title,
            body = it.htmlBody
        )
    }
}
