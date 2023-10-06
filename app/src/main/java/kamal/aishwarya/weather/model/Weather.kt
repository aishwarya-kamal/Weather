package kamal.aishwarya.weather.model

import kamal.aishwarya.weather.data.model.WeatherResponse.NetworkCurrentWeather.Condition

data class Weather(
    val temperature: Int,
    val wind: Int,
    val humidity: Int,
    val feelsLike: Int,
    val condition: Condition,
    val uv: Int,
    val name: String,
)
