package kamal.aishwarya.weather.model

import kamal.aishwarya.weather.data.model.WeatherResponse.NetworkCurrentWeather.Condition

data class Weather(
    val temperature: Double,
    val wind: Double,
    val humidity: Int,
    val feelslikeC: Double,
    val condition: Condition,
    val uv: Double,
    val name: String,
)
