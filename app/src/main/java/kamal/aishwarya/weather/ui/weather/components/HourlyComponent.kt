package kamal.aishwarya.weather.ui.weather.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import kamal.aishwarya.weather.R

@Composable
fun HourlyComponent(
    modifier: Modifier = Modifier,
    time: String,
    icon: String,
    temperature: String,
) {
    ElevatedCard(
        modifier = modifier
            .padding(end = 16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                modifier = Modifier.padding(start = 4.dp, end = 4.dp, bottom = 4.dp),
                text = time.substring(11, 13),
                style = MaterialTheme.typography.titleSmall
            )
            AsyncImage(
                modifier = Modifier.size(42.dp),
                model = stringResource(R.string.hourly_weather_icon, icon),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                error = painterResource(id = R.drawable.ic_placeholder),
                placeholder = painterResource(id = R.drawable.ic_placeholder),

                )
            Text(
                text = temperature,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}


@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HourlyComponentPreview() {
    HourlyComponent(
        time = "2023-10-07",
        icon = "116.png",
        temperature = "23",
    )
}