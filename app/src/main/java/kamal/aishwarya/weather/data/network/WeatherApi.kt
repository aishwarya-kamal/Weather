package kamal.aishwarya.weather.data.network

import kamal.aishwarya.weather.BuildConfig
import kamal.aishwarya.weather.data.model.ForecastResponse
import kamal.aishwarya.weather.utils.DEFAULT_WEATHER_DESTINATION
import kamal.aishwarya.weather.utils.NUMBER_OF_DAYS
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("forecast.json")
    suspend fun getWeatherForecast(
        @Query("key") key: String = BuildConfig.API_KEY,
        @Query("q") city: String = DEFAULT_WEATHER_DESTINATION,
        @Query("days") days: Int = NUMBER_OF_DAYS,
    ): ForecastResponse
}