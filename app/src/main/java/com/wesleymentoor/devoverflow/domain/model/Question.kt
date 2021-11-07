package com.wesleymentoor.devoverflow.domain.model

import android.os.Parcelable
import com.wesleymentoor.devoverflow.data.remote.dto.Owner
import kotlinx.parcelize.Parcelize

@Parcelize
data class Question(
    val tags: List<String>,
    val owner: Owner,
    val is_answered: Boolean,
    val view_count: Int,
    val answer_count: Int,
    val score: Int,
    val question_id: Long,
    val link: String,
    val title: String,
    val body: String
): Parcelable
