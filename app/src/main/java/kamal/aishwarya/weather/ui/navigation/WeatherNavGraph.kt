package kamal.aishwarya.weather.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kamal.aishwarya.weather.ui.weather.WeatherScreen

@Composable
fun WeatherNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Weather.route,
        ) {

        composable(route = Screen.Weather.route)  {
            WeatherScreen()
        }
    }
}