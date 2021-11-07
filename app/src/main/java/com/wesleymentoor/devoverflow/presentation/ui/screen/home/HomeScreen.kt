package com.wesleymentoor.devoverflow.presentation.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.google.accompanist.pager.*
import com.wesleymentoor.devoverflow.presentation.ui.components.TabNavigationScreens
import com.wesleymentoor.devoverflow.presentation.ui.screen.home.tabs.AnnouncementTab
import com.wesleymentoor.devoverflow.presentation.ui.screen.home.tabs.Tutorials
import com.wesleymentoor.devoverflow.presentation.ui.screen.home.tabs.question.QuestionTab
import com.wesleymentoor.devoverflow.presentation.ui.theme.DevOverflowTheme
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    navController: NavController
) {

    DevOverflowTheme {
        HomeScreenContent(navController)
    }

}
@OptIn(ExperimentalPagerApi::class)
@Composable
private fun HomeScreenContent(navController: NavController) {

    val tabs = listOf(
        TabNavigationScreens.Questions,
        TabNavigationScreens.Announcements,
        TabNavigationScreens.Tutorials
    )
    val pagerState = rememberPagerState(pageCount = tabs.size)
    
    Column {
        Tabs(tabs = tabs, pagerState = pagerState)
        TabsContent(tabs = tabs, pagerState = pagerState, navController = navController)
    }

}

@OptIn(ExperimentalPagerApi::class, ExperimentalMaterialApi::class)
@Composable
private fun Tabs(tabs: List<TabNavigationScreens>, pagerState: PagerState) {
    val scope = rememberCoroutineScope()

    ScrollableTabRow(
        selectedTabIndex = pagerState.currentPage,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )
        }
    ) {
        tabs.forEachIndexed { index, tabNavigationScreens ->
            Tab(
                selected = pagerState.currentPage == index,
                text = { Text(
                    text = tabNavigationScreens.title,
                    fontWeight = FontWeight.Bold
                )},
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun TabsContent(tabs: List<TabNavigationScreens>, pagerState: PagerState, navController: NavController) {
    HorizontalPager(state = pagerState) { page: Int ->

        when (tabs[page]) {
            TabNavigationScreens.Questions -> QuestionTab(navController = navController)
            TabNavigationScreens.Tutorials -> Tutorials()
            TabNavigationScreens.Announcements -> AnnouncementTab()
        }
    }

}
