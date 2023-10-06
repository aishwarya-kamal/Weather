package kamal.aishwarya.weather.ui.weather

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import kamal.aishwarya.weather.R
import kamal.aishwarya.weather.data.model.WeatherResponse
import kamal.aishwarya.weather.model.Weather
import kamal.aishwarya.weather.ui.weather.common.WeatherComponent

@Composable
fun WeatherScreen(
    modifier: Modifier = Modifier,
    viewModel: WeatherViewModel = hiltViewModel(),
) {
    val uiState: WeatherUiState by viewModel.uiState
    WeatherScreenContent(uiState.weather, modifier)
}

@Composable
fun WeatherScreenContent(
    weather: Weather?,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 16.dp, top = 16.dp, bottom = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = weather?.name.orEmpty(),
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(Modifier.height(8.dp))

        AsyncImage(
            modifier = Modifier.size(44.dp),
            model = "https:${weather?.condition?.icon}",
            contentDescription = null,
            error = painterResource(id = R.drawable.ic_placeholder),
            placeholder = painterResource(id = R.drawable.ic_placeholder),
        )
        Text(
            text = "${weather?.temperature.toString()}°C",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "Feels like ${weather?.feelsLike.toString()}°C",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            WeatherComponent(
                modifier = Modifier.weight(1f),
                weatherValue = weather?.wind.toString(),
                weatherUnit = "km/h",
                iconId = R.drawable.ic_wind,
            )
            WeatherComponent(
                modifier = Modifier.weight(1f),
                weatherValue = weather?.uv.toString(),
                weatherUnit = "uv index",
                iconId = R.drawable.ic_uv,
            )
            WeatherComponent(
                modifier = Modifier.weight(1f),
                weatherValue = weather?.humidity.toString(),
                weatherUnit = "percentage %",
                iconId = R.drawable.ic_humidity,
            )

        }
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun WeatherScreenContentPreview() {
    WeatherScreenContent(
        Weather(
            25,
            22,
            35,
            23,
            WeatherResponse.NetworkCurrentWeather.Condition(10, "", ""),
            3,
            "Munich"
        )
    )
}