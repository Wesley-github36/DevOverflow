package com.wesleymentoor.devoverflow.presentation.ui.components

import androidx.compose.runtime.Composable
import com.wesleymentoor.devoverflow.presentation.ui.screen.home.tabs.AnnouncementTab
import com.wesleymentoor.devoverflow.presentation.ui.screen.home.tabs.question.QuestionTab
import com.wesleymentoor.devoverflow.presentation.ui.screen.home.tabs.Tutorials

sealed class TabNavigationScreens(val title: String) {
    object Questions: TabNavigationScreens("Questions")
    object Announcements: TabNavigationScreens("Announcements")
    object Tutorials: TabNavigationScreens("Tutorails")
}