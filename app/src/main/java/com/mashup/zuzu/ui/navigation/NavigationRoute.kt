package com.mashup.zuzu.ui.navigation

/**
 * @Created by 김현국 2022/07/23
 */
sealed class NavigationRoute(val route: String) {
    object HomeScreenGraph : NavigationRoute("home_screen") {
        object HomeScreen : NavigationRoute("home_screen.screen")
    }
    object CategoryScreenGraph : NavigationRoute("category_screen") {
        object CategoryScreen : NavigationRoute("category_screen.screen")
    }
    object UserScreenGraph : NavigationRoute("user_screen") {
        object UserScreen : NavigationRoute("user_screen.screen")
        object SettingScreen : NavigationRoute("user_screen.setting")
        object EditUserProfileBottomSheet : NavigationRoute("user_screen.edit_user_profile")
        object LeaveScreen : NavigationRoute("user_screen.leave")
    }
}

val shouldShowNavigationItems = listOf(
    NavigationRoute.HomeScreenGraph.HomeScreen,
    NavigationRoute.UserScreenGraph.UserScreen
)
val shouldShowFloatingButtonInScreen = listOf(
    NavigationRoute.HomeScreenGraph.HomeScreen
)
