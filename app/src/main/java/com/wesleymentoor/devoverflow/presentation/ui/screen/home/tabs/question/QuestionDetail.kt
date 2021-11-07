package com.wesleymentoor.devoverflow.presentation.ui.screen.home.tabs.question

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.wesleymentoor.devoverflow.R
import com.wesleymentoor.devoverflow.common.util.TagRow
import com.wesleymentoor.devoverflow.data.remote.dto.Owner
import com.wesleymentoor.devoverflow.domain.model.QuestionById

@Composable
fun QuestionDetail(
    questionId: Long?,
    viewModel: QuestionTabViewModel = hiltViewModel<QuestionTabViewModel>().also {
        it.onRefreshQuestionById(questionId!!)
    }
) {
    val questionById = viewModel.questionById.collectAsState()

    Column {
        Card(
            elevation = 8.dp
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                Text(text = stringResource(id = R.string.app_name))

                Row {
                    Text(text = "Sign up")
                    Text(text = "Log in")
                }
            }


        }
    }
}



@Preview(
    showBackground = true,
    name = "Light Mode"
)
@Preview(
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun PreviewQuestionDetail(
    question: QuestionById = questionById
) {
    Column {
        Card(
            elevation = 8.dp,
            modifier = Modifier
                .fillMaxWidth()

        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(vertical = 4.dp, horizontal = 8.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Bold
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = "Sign up",
                        style = MaterialTheme.typography.body2,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Log in",
                        style = MaterialTheme.typography.body2,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.height(IntrinsicSize.Min)
        ) {
            if (question.is_answered) {
                Surface(
                    color = Color.Green.copy(0.38f),
                    modifier = Modifier.weight(0.2f)
                ) {
                    Column {
                        Text(
                            text = question.answer_count.toString(),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.weight(0.5f)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.tick),
                            contentDescription = "Question is answered"
                        )

                    }
                }
            }
            else {
                Text(
                    text = question.answer_count.toString(),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(0.2f)
                )
            }

            Divider()
            Column(
                modifier = Modifier
                    .weight(0.8f)
                    .padding(4.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = question.title,
                    style = MaterialTheme.typography.h6,
                )
                TagRow(tags = questionById.tags, modifier = Modifier.height(8.dp))
            }
        }
        Text(
            text = question.body
        )
    }

}

val questionById = QuestionById(
    tags = mutableListOf("ios","swift","xcode12"),
    owner = Owner(
        5020067,
        336,
        4033767,"registered",
        "https://www.gravatar.com/avatar/1045074c4dfa0eef28e630d22ab19283?s=128&d=identicon&r=PG&f=1",
        "Stefo",
        "https://stackoverflow.com/users/4033767/stefo"),
    is_answered = true,
    view_count = 9842,
    accepted_answer_id = 64390836,
    answer_count = 5,
    score = 15,
    last_activity_date = 1632676572,
    creation_date = 1600857330,
    question_id = 64026065,
    body = "<p>After updating to Xcode 12 the project gives me this error when building on simulator:</p>\n<pre><code>Could not find module 'FrameworkName' for target 'arm64-apple-ios-simulator'; found: x86_64-apple-ios-simulator, x86_64\n</code></pre>\n<p>The framework is installed with cocoapods.\nIt works with Xcode 11. Building on &quot;Any iOS Device&quot; or real iPhone with Xcode 12 also works just fine.\nWhat's different in Xcode 12?</p>\n",
    link = "https://stackoverflow.com/questions/64026065/xcode-12-issue-could-not-find-module-frameworkname-for-target-arm64-apple-i",
    title ="Xcode 12 issue - Could not find module &#39;FrameworkName&#39; for target &#39;arm64-apple-ios-simulator&#39;; found: x86_64-apple-ios-simulator, x86_64"
)