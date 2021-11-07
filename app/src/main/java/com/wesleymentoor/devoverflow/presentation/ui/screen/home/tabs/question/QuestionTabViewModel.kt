package com.wesleymentoor.devoverflow.presentation.ui.screen.home.tabs.question

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wesleymentoor.devoverflow.common.dispatcher.DispatcherProvider
import com.wesleymentoor.devoverflow.common.util.Resource
import com.wesleymentoor.devoverflow.common.util.errorMessage
import com.wesleymentoor.devoverflow.data.remote.dto.asDomainModel
import com.wesleymentoor.devoverflow.domain.model.Question
import com.wesleymentoor.devoverflow.domain.model.QuestionById
import com.wesleymentoor.devoverflow.domain.repository.DevOverflowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class QuestionTabViewModel @Inject constructor(
    private val repository: DevOverflowRepository,
    private val dispatcherProvider: DispatcherProvider
): ViewModel() {


    private val _questions = MutableStateFlow<Resource<List<Question>>>(Resource.loading(null))
    val questions = _questions as StateFlow<Resource<List<Question>>>

    private val _questionById = MutableStateFlow<Resource<QuestionById>>(Resource.loading(null))
    val questionById = _questionById as StateFlow<Resource<QuestionById>>

    init {
        getQuestions()
    }

    private fun getQuestions() = viewModelScope.launch(dispatcherProvider.ioDispatcher()) {

        repository.getQuestions(fromDate = fromDate.toString(), toDate = toDate.toString())
            .flowOn(dispatcherProvider.ioDispatcher())
            .catch { throwable ->
                _questions.value = Resource.error(msg = errorMessage(throwable = throwable))
            }
            .collect { questionContainer ->
                val questionList = questionContainer.asDomainModel()
                _questions.value = Resource.success(questionList)
            }
    }
    private fun getQuestionById(id: Long) = viewModelScope.launch(dispatcherProvider.ioDispatcher()) {
        repository.getQuestionById(id)
            .flowOn(dispatcherProvider.ioDispatcher())
            .catch { throwable ->
                _questionById.value = Resource.error(msg = errorMessage(throwable = throwable))

            }.collect { data ->
                _questionById.value = Resource.success(data.asDomainModel())
            }
    }

    /**
     * These functions are called when there was a network error
     */
    fun onRefreshQuestionById(id: Long) {
        getQuestionById(id)
    }
    fun onRefreshViewModel() {
        getQuestions()
    }

    companion object {
        val fromDate: Long = System.currentTimeMillis() / 1000

        val toDate: Long = let {
            val calendar = Calendar.getInstance()
            calendar.add(Calendar.MONTH, -1)

            val prevMonthDate = calendar.time.time
            prevMonthDate / 1000
        }
    }
}