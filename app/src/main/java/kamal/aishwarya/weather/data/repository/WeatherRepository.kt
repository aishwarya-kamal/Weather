package kamal.aishwarya.weather.data.repository

import kamal.aishwarya.weather.model.Weather
import kamal.aishwarya.weather.utils.Result
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    fun getWeatherForecast(city: String): Flow<Result<Weather>>
}