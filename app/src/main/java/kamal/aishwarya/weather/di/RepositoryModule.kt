package kamal.aishwarya.weather.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import kamal.aishwarya.weather.data.network.WeatherApi
import kamal.aishwarya.weather.data.repository.DefaultWeatherRepository
import javax.inject.Singleton

@Module
@InstallIn(Singleton::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(weatherApi: WeatherApi) =
        DefaultWeatherRepository(weatherApi)
}