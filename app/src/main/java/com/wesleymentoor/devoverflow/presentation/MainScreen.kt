package com.wesleymentoor.devoverflow.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.wesleymentoor.devoverflow.presentation.ui.components.NavigationScreens
import com.wesleymentoor.devoverflow.presentation.ui.screen.account.AccountScreen
import com.wesleymentoor.devoverflow.presentation.ui.screen.home.HomeScreen
import com.wesleymentoor.devoverflow.presentation.ui.screen.home.tabs.question.QuestionDetail
import com.wesleymentoor.devoverflow.presentation.ui.screen.notification.NotificationScreen
import com.wesleymentoor.devoverflow.presentation.ui.screen.search.SearchScreen
import com.wesleymentoor.devoverflow.presentation.ui.theme.DevOverflowTheme
import com.wesleymentoor.devoverflow.presentation.ui.theme.secondary


@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold (
        topBar = { TopBar(navController) },
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) { innerPadding ->
        Navigation(navController, innerPadding)
    }
}

@Composable
fun TopBar(navController: NavHostController) {
    DevOverflowTheme {
        TopAppBar {
            val routeName by navController.currentBackStackEntryAsState()
            val name = routeName?.destination?.route

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 4.dp)
            ) {
                Text(
                    text = "$name",
                    style = MaterialTheme.typography.h6
                )
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {

    DevOverflowTheme {
        val bottomNavigationItems = listOf(
            NavigationScreens.BottomNavigation.Home,
            NavigationScreens.BottomNavigation.Search,
            NavigationScreens.BottomNavigation.Account,
            NavigationScreens.BottomNavigation.Notifications

        )

        BottomNavigation{
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination

            bottomNavigationItems.forEach { item ->
                BottomNavigationItem(
                    icon = { Icon(
                        painter = painterResource(id = item.icon!!),
                        contentDescription = stringResource(id = item.resourceId!!)
                    )
                    },
                    label = {
                        Text(
                            text = stringResource(id = item.resourceId!!),
                            softWrap = true,
                            maxLines = 1
                        )},
                    alwaysShowLabel = true,
                    selectedContentColor = secondary.copy(0.60f),
                    unselectedContentColor = LocalContentColor.current,
                    selected = currentDestination?.hierarchy?.any {it.route == item.route} == true,
                    onClick = {
                        navController.navigate(item.route) {
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    })
            }
        }
    }
}

@Composable
fun Navigation(navHostController: NavHostController, innerPadding: PaddingValues) {

    NavHost(
        navController = navHostController,
        startDestination = NavigationScreens.BottomNavigation.Home.route,
        modifier = Modifier.padding(innerPadding)) {

        composable(NavigationScreens.BottomNavigation.Home.route) {
            HomeScreen(navHostController)
        }
        composable(NavigationScreens.BottomNavigation.Search.route) {
            SearchScreen()
        }
        composable(NavigationScreens.BottomNavigation.Account.route) {
            AccountScreen()
        }
        composable(NavigationScreens.BottomNavigation.Notifications.route) {
            NotificationScreen()
        }

        composable(
            route = NavigationScreens.TopNavigation.QuestionDetail.route+"/{questionId}",
            arguments = listOf(navArgument("questionId"){ type = NavType.LongType })
        ) { entry ->
            QuestionDetail(entry.arguments?.getLong("questionId"))
        }
    }
}