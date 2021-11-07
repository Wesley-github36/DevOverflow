package com.wesleymentoor.devoverflow.presentation.ui.screen.home.tabs.question

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.wesleymentoor.devoverflow.common.util.Resource
import com.wesleymentoor.devoverflow.common.util.Status
import com.wesleymentoor.devoverflow.domain.model.Question
import com.wesleymentoor.devoverflow.presentation.ui.components.CircularIndeterminateProgressbar
import com.wesleymentoor.devoverflow.presentation.ui.components.ErrorScreen
import com.wesleymentoor.devoverflow.presentation.ui.components.NavigationScreens
import com.wesleymentoor.devoverflow.presentation.ui.components.QuestionCard

@Composable
fun QuestionTab(
    navController: NavController,
    questionTabViewModel: QuestionTabViewModel = hiltViewModel()
) {
    val questions: Resource<List<Question>> by questionTabViewModel.questions.collectAsState()

    questions.let { _questions ->
        when (_questions.status) {

            Status.LOADING -> CircularIndeterminateProgressbar(isVisible = true)

            Status.SUCCESS -> {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp)
                ) {
                    items(_questions.data!!) { _question ->
                        QuestionCard(
                            question = _question,
                            onItemClick = {
                                navController.navigate(
                                    route = NavigationScreens.TopNavigation.QuestionDetail.route + "/${_question.question_id}",
                                )
                            }
                        )
                    }
                }
            }
            Status.ERROR -> ErrorScreen(
                error = _questions.error!!,
                onClick = { questionTabViewModel.onRefreshViewModel() }
            )
        }
    }

}