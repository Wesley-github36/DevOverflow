package com.wesleymentoor.devoverflow.data.remote.service

import com.wesleymentoor.devoverflow.data.remote.dto.QuestionByIdDTO
import com.wesleymentoor.devoverflow.data.remote.dto.QuestionContainerDto
import retrofit2.http.GET
import retrofit2.http.Path

//https://api.stackexchange.com/2.3/questions/64026065?order=desc&sort=activity&site=stackoverflow


interface DevOverflowApi {

    @GET("2.3/questions?pagesize=100&fromdate={fromDate}&todate={toDate}&order=desc&sort=creation&site=stackoverflow")
    suspend fun loadAllQuestions(@Path("fromDate") fromDate: String, @Path("toDate") toDate: String):
            QuestionContainerDto

    @GET("2.3/questions/{questionId}?order=desc&sort=activity&site=stackoverflow")
    suspend fun loadQuestionById(@Path("questionId") id: Long): QuestionByIdDTO

}