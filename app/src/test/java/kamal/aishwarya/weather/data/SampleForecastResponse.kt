package kamal.aishwarya.weather.data

import kamal.aishwarya.weather.data.model.ForecastResponse
import kamal.aishwarya.weather.data.model.ForecastResponse.Current
import kamal.aishwarya.weather.data.model.ForecastResponse.Location
import kamal.aishwarya.weather.data.model.ForecastResponse.NetworkForecast
import kamal.aishwarya.weather.data.model.ForecastResponse.NetworkForecast.NetworkForecastday.Astro
import kamal.aishwarya.weather.data.model.ForecastResponse.NetworkForecast.NetworkForecastday.Day
import kamal.aishwarya.weather.data.model.ForecastResponse.NetworkForecast.NetworkForecastday.Day.Condition
import kamal.aishwarya.weather.data.model.ForecastResponse.NetworkForecast.NetworkForecastday.NetworkHour

val sampleForecastResponse: ForecastResponse
    get() = ForecastResponse(
        current = Current(
            cloud = 50,
            condition = Current.Condition(
                code = 200,
                icon = "sunny-icon",
                text = "Sunny"
            ),
            feelslikeC = 25.0,
            feelslikeF = 77.0,
            gustKph = 10.0,
            gustMph = 6.2,
            humidity = 60,
            isDay = 1,
            lastUpdated = "2023-10-14 12:00 PM",
            lastUpdatedEpoch = 1634217600,
            precipIn = 0.0,
            precipMm = 0.0,
            pressureIn = 29.92,
            pressureMb = 1013.25,
            tempC = 20.0,
            tempF = 68.0,
            uv = 5.0,
            visKm = 10.0,
            visMiles = 6.2,
            windDegree = 180,
            windDir = "S",
            windKph = 10.0,
            windMph = 6.2
        ),
        forecast = NetworkForecast(
            forecastday = listOf(
                NetworkForecast.NetworkForecastday(
                    astro = Astro(
                        isMoonUp = 1,
                        isSunUp = 1,
                        moonIllumination = "100%",
                        moonPhase = "Full Moon",
                        moonrise = "06:30 PM",
                        moonset = "06:30 AM",
                        sunrise = "06:30 AM",
                        sunset = "06:30 PM"
                    ),
                    date = "2023-10-15",
                    dateEpoch = 1634299200,
                    day = Day(
                        avghumidity = 60.0,
                        avgtempC = 20.0,
                        avgtempF = 68.0,
                        avgvisKm = 10.0,
                        avgvisMiles = 6.2,
                        condition = Condition(
                            code = 200,
                            icon = "sunny-icon",
                            text = "Sunny"
                        ),
                        dailyChanceOfRain = 10,
                        dailyChanceOfSnow = 0,
                        dailyWillItRain = 1,
                        dailyWillItSnow = 0,
                        maxtempC = 25.0,
                        maxtempF = 77.0,
                        maxwindKph = 15.0,
                        maxwindMph = 9.3,
                        mintempC = 15.0,
                        mintempF = 59.0,
                        totalprecipIn = 0.0,
                        totalprecipMm = 0.0,
                        totalsnowCm = 0.0,
                        uv = 5.0
                    ),
                    hour = listOf(
                        NetworkHour(
                            chanceOfRain = 10,
                            chanceOfSnow = 0,
                            cloud = 50,
                            condition = NetworkHour.Condition(
                                code = 200,
                                icon = "sunny-icon",
                                text = "Sunny"
                            ),
                            dewpointC = 15.0,
                            dewpointF = 59.0,
                            feelslikeC = 20.0,
                            feelslikeF = 68.0,
                            gustKph = 15.0,
                            gustMph = 9.3,
                            heatindexC = 20.0,
                            heatindexF = 68.0,
                            humidity = 60,
                            isDay = 1,
                            precipIn = 0.0,
                            precipMm = 0.0,
                            pressureIn = 29.92,
                            pressureMb = 1013.25,
                            tempC = 20.0,
                            tempF = 68.0,
                            time = "08:00 AM",
                            timeEpoch = 1634313600,
                            uv = 5.0,
                            visKm = 10.0,
                            visMiles = 6.2,
                            willItRain = 1,
                            willItSnow = 0,
                            windDegree = 180,
                            windDir = "S",
                            windKph = 15.0,
                            windMph = 9.3,
                            windchillC = 20.0,
                            windchillF = 68.0
                        )
                    )
                )
            )
        ),
        location = Location(
            country = "US",
            lat = 37.7749,
            localtime = "2023-10-14 12:00 PM",
            localtimeEpoch = 1634217600,
            lon = -122.4194,
            name = "San Francisco",
            region = "California",
            tzId = "America/Los_Angeles"
        )
    )
