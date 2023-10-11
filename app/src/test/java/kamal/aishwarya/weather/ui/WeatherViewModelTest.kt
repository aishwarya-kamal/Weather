package kamal.aishwarya.weather.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kamal.aishwarya.weather.data.repository.DefaultWeatherRepository
import kamal.aishwarya.weather.ui.weather.WeatherUiState
import kamal.aishwarya.weather.ui.weather.WeatherViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever
import java.io.IOException

class WeatherViewModelTest {

    @get:Rule
    val coroutineRule = InstantTaskExecutorRule()

    private lateinit var viewModel: WeatherViewModel

    private val mockWeatherRepository: DefaultWeatherRepository = mock()
    @Before
    fun setUp() {
        viewModel = WeatherViewModel(mockWeatherRepository)
    }

    @Test
    fun ` some test`() {
        whenever(mockWeatherRepository.getWeatherForecast("Munich")).thenThrow(IOException("No internt"))

        viewModel.getWeather()

        assert(viewModel.uiState.value is WeatherUiState)
    }

}