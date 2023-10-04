package kamal.aishwarya.weather.data.network

import kamal.aishwarya.weather.data.model.WeatherResponse
import kamal.aishwarya.weather.utils.API_KEY
import kamal.aishwarya.weather.utils.DEFAULT_WEATHER_DESTINATION
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("current.json")
    suspend fun getWeather(
        @Query("key") key: String = API_KEY,
        @Query("q") city: String = DEFAULT_WEATHER_DESTINATION,
    ): WeatherResponse
}