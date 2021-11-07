package com.wesleymentoor.devoverflow.data.remote.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Owner(
    val account_id: Long,
    val reputation: Int,
    val user_id: Long,
    val user_type: String,
    val profile_image: String,
    val display_name: String,
    val link: String
): Parcelable
