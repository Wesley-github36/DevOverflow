package com.wesleymentoor.devoverflow.data.remote.dto

import com.wesleymentoor.devoverflow.domain.model.QuestionById

data class QuestionByIdDTO(
    val has_more: Boolean,
    val items: List<Item>,
    val quota_max: Int,
    val quota_remaining: Int
)


fun QuestionByIdDTO.asDomainModel(): QuestionById {
    return items.map {
        QuestionById(
            accepted_answer_id = it.accepted_answer_id,
            answer_count = it.answer_count,
            creation_date = it.creation_date,
            is_answered = it.is_answered,
            last_activity_date = it.last_activity_date,
            owner = it.owner,
            link = it.link,
            question_id = it.question_id,
            score = it.score,
            tags = it.tags,
            title = it.title,
            view_count = it.view_count,
            body = it.body
        )
    }.first()
}