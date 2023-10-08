package kamal.aishwarya.weather.ui.weather

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices.PIXEL_XL
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import kamal.aishwarya.weather.R
import kamal.aishwarya.weather.data.model.ForecastResponse.Current.Condition
import kamal.aishwarya.weather.model.Forecast
import kamal.aishwarya.weather.model.Hour
import kamal.aishwarya.weather.model.Weather
import kamal.aishwarya.weather.ui.theme.WeatherTheme
import kamal.aishwarya.weather.ui.weather.components.Animation
import kamal.aishwarya.weather.ui.weather.components.ForecastComponent
import kamal.aishwarya.weather.ui.weather.components.HourlyComponent
import kamal.aishwarya.weather.ui.weather.components.WeatherComponent
import kamal.aishwarya.weather.utils.toFormattedDate
import java.util.Locale
import kotlin.random.Random

@Composable
fun WeatherScreen(
    modifier: Modifier = Modifier,
    viewModel: WeatherViewModel = hiltViewModel(),
) {
    val uiState: WeatherUiState by viewModel.uiState
    Scaffold(
        topBar = { WeatherTopAppBar() },
        content = { paddingValues ->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                color = MaterialTheme.colorScheme.background
            ) {
                WeatherScreenContent(uiState = uiState, modifier = modifier)
            }
        },
    )
}

@Composable
fun WeatherScreenContent(
    uiState: WeatherUiState,
    modifier: Modifier = Modifier,
) {
    when {
        uiState.isLoading -> {
            Animation(modifier = Modifier.fillMaxSize(), animation = R.raw.animation_loading)
        }

        uiState.errorMessage.isNotEmpty() -> {
            Animation(modifier = Modifier.fillMaxSize(), animation = R.raw.animation_error)
        }

        else -> {
            WeatherSuccessState(modifier = modifier, uiState = uiState)
        }
    }
}

@Composable
private fun WeatherSuccessState(
    modifier: Modifier,
    uiState: WeatherUiState,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = uiState.weather?.name.orEmpty(),
            style = MaterialTheme.typography.headlineLarge
        )
        Text(
            text = uiState.weather?.date?.toFormattedDate().orEmpty(),
            style = MaterialTheme.typography.bodyLarge
        )

        AsyncImage(
            modifier = Modifier.size(64.dp),
            model = stringResource(
                R.string.icon_image_url,
                uiState.weather?.condition?.icon.orEmpty(),
            ),
            contentDescription = null,
            error = painterResource(id = R.drawable.ic_placeholder),
            placeholder = painterResource(id = R.drawable.ic_placeholder),
        )
        Text(
            text = stringResource(
                R.string.temperature_value_in_celsius,
                uiState.weather?.temperature.toString()
            ),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
        )
        Text(
            modifier = Modifier.padding(start = 12.dp, end = 12.dp),
            text = uiState.weather?.condition?.text.orEmpty(),
            style = MaterialTheme.typography.bodyMedium,
        )
        Text(
            modifier = Modifier.padding(bottom = 4.dp),
            text = stringResource(
                R.string.feels_like_temperature_in_celsius,
                uiState.weather?.feelsLike.toString()
            ),
            style = MaterialTheme.typography.bodySmall
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(painter = painterResource(id = R.drawable.ic_sunrise), contentDescription = null)
            Text(
                modifier = Modifier.padding(start = 4.dp),
                text = uiState.weather?.forecasts?.get(0)?.sunrise?.lowercase(Locale.US).orEmpty(),
                style = MaterialTheme.typography.bodySmall,
            )
            Spacer(modifier = Modifier.width(16.dp))
            Image(painter = painterResource(id = R.drawable.ic_sunset), contentDescription = null)
            Text(
                modifier = Modifier.padding(start = 4.dp),
                text = uiState.weather?.forecasts?.get(0)?.sunset?.lowercase(Locale.US).orEmpty(),
                style = MaterialTheme.typography.bodySmall,
            )
        }
        Spacer(Modifier.height(32.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
        ) {
            WeatherComponent(
                modifier = Modifier.weight(1f),
                weatherLabel = stringResource(R.string.wind_speed_label),
                weatherValue = uiState.weather?.wind.toString(),
                weatherUnit = stringResource(R.string.wind_speed_unit),
                iconId = R.drawable.ic_wind,
            )
            WeatherComponent(
                modifier = Modifier.weight(1f),
                weatherLabel = stringResource(R.string.uv_index_label),
                weatherValue = uiState.weather?.uv.toString(),
                weatherUnit = stringResource(R.string.uv_unit),
                iconId = R.drawable.ic_uv,
            )
            WeatherComponent(
                modifier = Modifier.weight(1f),
                weatherLabel = stringResource(R.string.humidity_label),
                weatherValue = uiState.weather?.humidity.toString(),
                weatherUnit = stringResource(R.string.humidity_unit),
                iconId = R.drawable.ic_humidity,
            )
        }

        Spacer(Modifier.height(32.dp))
        Text(
            text = stringResource(R.string.today),
            style = MaterialTheme.typography.bodyMedium,
            modifier = modifier
                .align(Alignment.Start)
                .padding(horizontal = 16.dp),
        )
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(top = 8.dp, start = 16.dp),
        ) {
            uiState.weather?.forecasts?.get(0)?.let { forecast ->
                items(forecast.hour) { hour ->
                    HourlyComponent(
                        time = hour.time,
                        icon = hour.icon,
                        temperature = stringResource(
                            R.string.temperature_value_in_celsius,
                            hour.temperature,
                        )
                    )
                }
            }
        }

        Spacer(Modifier.height(32.dp))
        Text(
            text = stringResource(R.string.forecast),
            style = MaterialTheme.typography.bodyMedium,
            modifier = modifier
                .align(Alignment.Start)
                .padding(horizontal = 16.dp),
        )

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(top = 8.dp, start = 16.dp),
        ) {
            uiState.weather?.let { weather ->
                items(weather.forecasts) { forecast ->
                    ForecastComponent(
                        date = forecast.date,
                        icon = forecast.icon,
                        minTemp = stringResource(
                            R.string.temperature_value_in_celsius,
                            forecast.minTemp
                        ),
                        maxTemp = stringResource(
                            R.string.temperature_value_in_celsius,
                            forecast.maxTemp,
                        ),
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherTopAppBar() {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onBackground,
        ),
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                fontWeight = FontWeight.Bold,
            )
        },
    )
}

@Preview(name = "Light Mode", showBackground = true, showSystemUi = true)
@Preview(
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showSystemUi = true,
    showBackground = true,
    device = PIXEL_XL
)
@Composable
fun WeatherScreenContentPreview() {
    val hourlyForecast = mutableListOf<Hour>()
    for (i in 0 until 24) {
        hourlyForecast.add(Hour("yyyy-mm-dd ${String.format("%02d", i)}", "", "${Random.nextInt(18, 21)}"))
    }
    val forecasts = mutableListOf<Forecast>()
    for (i in 0..9) {
        forecasts.add(Forecast("2023-10-${String.format("%02d", i)}", "${Random.nextInt(18, 21)}", "${Random.nextInt(10, 15)}", "07:20 am", "06:40 pm", "", hourlyForecast))
    }
    WeatherTheme {
        Surface {
            WeatherScreenContent(
                WeatherUiState(
                    Weather(
                        temperature = 19,
                        date = "Oct 7",
                        wind = 22,
                        humidity = 35,
                        feelsLike = 18,
                        condition = Condition(10, "", "Cloudy"),
                        uv = 2,
                        name = "Munich",
                        forecasts = forecasts,
                    )
                )
            )
        }
    }
}