package kamal.aishwarya.weather.ui.weather.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import kamal.aishwarya.weather.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@Composable
fun ForecastComponent(
    modifier: Modifier = Modifier,
    date: String,
    icon: String,
    minTemp: String,
    maxTemp: String,
) {
    val dateComponents = date.split("-")
    if (dateComponents.size == 3) {
        val year = dateComponents[0].toInt()
        val month = dateComponents[1].toInt() - 1 // Subtract 1 as months are 0-based
        val day = dateComponents[2].toInt()

        val calendar = Calendar.getInstance()
        calendar.set(year, month, day)
        val outputDateFormat = SimpleDateFormat("EE", Locale.US)
        val dayString = outputDateFormat.format(calendar.time)

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
                    text = dayString,
                    style = MaterialTheme.typography.titleMedium
                )
                AsyncImage(
                    modifier = Modifier.size(42.dp),
                    model = "https:${icon}",
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    error = painterResource(id = R.drawable.ic_placeholder),
                    placeholder = painterResource(id = R.drawable.ic_placeholder),

                    )
                Row {
                    Text(
                        text = minTemp,
                        style = MaterialTheme.typography.bodySmall
                    )
                    Text(
                        text = maxTemp,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}


@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ForecastComponentPreview() {
    ForecastComponent(
        date = "2023-10-07",
        icon = "116.png",
        minTemp = "12",
        maxTemp = "23"
    )
}