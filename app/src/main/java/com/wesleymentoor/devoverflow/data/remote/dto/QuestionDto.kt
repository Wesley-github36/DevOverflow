package com.wesleymentoor.devoverflow.data.remote.dto

data class QuestionDto(
    val tags: List<String>,
    val owner: Owner,
    val is_answered: Boolean,
    val view_count: Int,
    val answer_count: Int,
    val score: Int,
    val last_activity_date: Long,
    val creation_date: Long,
    val question_id: Long,
    val content_license: String,
    val link: String,
    val title: String,
    val body: String
) {
    val htmlBody: String
        get() {
            return body.replace("\n", "<br>")
        }
}



