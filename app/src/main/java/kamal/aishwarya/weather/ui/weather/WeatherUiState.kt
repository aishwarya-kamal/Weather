package kamal.aishwarya.weather.ui.weather

import kamal.aishwarya.weather.model.Weather

data class WeatherUiState(
    val weather: Weather? = null,
    val isLoading: Boolean = false,
    val errorMessage: String = "",
)
