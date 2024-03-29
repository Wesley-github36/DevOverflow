package com.wesleymentoor.devoverflow.domain.model

import com.wesleymentoor.devoverflow.data.remote.dto.Owner

data class QuestionById(
    val accepted_answer_id: Int,
    val answer_count: Int,
    val creation_date: Int,
    val is_answered: Boolean,
    val last_activity_date: Int,
    val link: String,
    val owner: Owner,
    val question_id: Int,
    val score: Int,
    val tags: List<String>,
    val title: String,
    val view_count: Int,
    val body: String
)