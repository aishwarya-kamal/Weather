package kamal.aishwarya.weather.ui

import app.cash.turbine.test
import junit.framework.TestCase.assertEquals
import kamal.aishwarya.weather.data.repository.FakeWeatherRepository
import kamal.aishwarya.weather.data.repository.WeatherRepository
import kamal.aishwarya.weather.data.repository.fakeWeather
import kamal.aishwarya.weather.ui.weather.WeatherUiState
import kamal.aishwarya.weather.ui.weather.WeatherViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class WeatherViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var viewModel: WeatherViewModel

    private val weatherRepository: WeatherRepository = FakeWeatherRepository

    @Before
    fun setUp() {
        viewModel = WeatherViewModel(weatherRepository)
    }

    @Test
    fun `when getWeather completes, it should emit success state`() = runTest {
        viewModel.uiState.test {

            assertEquals(WeatherUiState(weather = fakeWeather), awaitItem())
        }
    }

    @Test
    fun `when getWeather completes, it should emit success state with humidity of 60`() = runTest {
        viewModel.uiState.test {

            assertEquals(WeatherUiState(weather = fakeWeather), awaitItem())
            assertEquals(WeatherUiState(weather = fakeWeather).weather?.humidity, 60)
        }
    }
}