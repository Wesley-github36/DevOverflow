package com.wesleymentoor.devoverflow.presentation.ui.components

import androidx.annotation.StringRes
import com.wesleymentoor.devoverflow.R

sealed class NavigationScreens(val route: String, @StringRes val resourceId: Int?, val icon: Int?) {

    class BottomNavigation {
        object Home : NavigationScreens("Home", R.string.home, R.drawable.ic_round_home_24)
        object Search : NavigationScreens("Search", R.string.search, R.drawable.ic_search_24)
        object Account : NavigationScreens("Account", R.string.account, R.drawable.ic_round_person_24)
        object Notifications : NavigationScreens("Notifications", R.string.notifications, R.drawable.ic_bell)
    }

    class TopNavigation {
        object QuestionDetail : NavigationScreens("QuestionDetails", null, null)
    }

}

