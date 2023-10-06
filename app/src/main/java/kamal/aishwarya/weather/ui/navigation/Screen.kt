package kamal.aishwarya.weather.ui.navigation

sealed class Screen(val route: String) {
    object Weather: Screen(route = "Weather")
    object Forecast: Screen(route = "Forecast")
}