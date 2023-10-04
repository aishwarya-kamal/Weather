package kamal.aishwarya.weather.data.repository

import kamal.aishwarya.weather.data.model.toWeather
import kamal.aishwarya.weather.data.network.WeatherApi
import kamal.aishwarya.weather.model.Weather
import kamal.aishwarya.weather.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class DefaultWeatherRepository @Inject constructor(
    private val weatherApi: WeatherApi,
) : WeatherRepository {
    override fun getWeather(): Flow<Result<Weather>> = flow {
        emit(Result.Loading)
        try {
            emit(Result.Success(weatherApi.getWeather().current.toWeather()))
        } catch (exception: HttpException) {
            emit(Result.Error(exception))
        }
    }
}