package kamal.aishwarya.weather.data.repository

import kamal.aishwarya.weather.data.model.toWeather
import kamal.aishwarya.weather.data.model.toWeatherForecast
import kamal.aishwarya.weather.data.network.WeatherApi
import kamal.aishwarya.weather.model.Weather
import kamal.aishwarya.weather.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject

class DefaultWeatherRepository @Inject constructor(
    private val weatherApi: WeatherApi,
) : WeatherRepository {
    override fun getWeatherForecast(): Flow<Result<Weather>> = flow {
        emit(Result.Loading)
        try {
            val result = weatherApi.getWeatherForecast().toWeather()
            emit(Result.Success(result))
        } catch (exception: HttpException) {
            emit(Result.Error(exception))
        } catch (exception: IOException) {
            emit(Result.Error(exception))
        } catch (exception: Exception) {
            emit(Result.Error(exception))
        }
    }
}