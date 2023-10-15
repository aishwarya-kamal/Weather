# Weather
[![Kotlin](https://img.shields.io/badge/kotlin-1.8.10-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![Gradle](https://img.shields.io/badge/Gradle-8-green?style=flat)](https://gradle.org)
<a href="https://github.com/aishwarya-kamal"><img alt="License" src="https://img.shields.io/static/v1?label=GitHub&message=aishwarya-kamal&color=C51162"/></a><br>
Weather is an Android app for Weather with Jetpack Compose. It uses [openweathermap API](https://openweathermap.org/api). It is single screen app which displays weather data for a city.
There is a search function in the top app bar to search for any city and display its weather data.

## 📐✏️ Architecture
The app is built with the Model-View-ViewModel (MVVM) architecture with Repository pattern which is used to separate the app's user interface, logic, and data.

- **Model**: Represents the data and the business logic of the app. It's the actual data and data sources, like databases or network requests.
- **View**: Represents the UI of the app. In your app, it would be the Jetpack Compose components that display the weather data to the user.
- **ViewModel**: It holds the data that the View needs, exposing this data through StateFlow.
- **Repository**: This is an additional layer between the ViewModel and the data source (in this case, the OpenWeatherMap API). The Repository centralizes the data fetching mechanism, so if in the future we decide to add another data source, such as a local database for offline caching, the ViewModel wouldn't need to know where the data is coming from. The Repository will handle data retrieval, whether it's from the API, local database, or other sources.

To visualize the flow:

- User opens the app and sees the main weather screen with weather details of the default city - Munich.
- User types a city name into the search bar.
- The app's ViewModel, through the Repository, makes a call to the OpenWeatherMap API.
- The API returns the weather data for the requested city.
- The Repository passes this data to the ViewModel.
- The ViewModel updates the View (the screen) with the fetched weather data, displaying it to the user.

In essence, this architecture ensures a separation of concerns, promoting a more scalable and maintainable codebase. It decouples the UI from the data and business logic, allowing each component to evolve independently.


## 🛠 Tech Stack
- [Kotlin](https://developer.android.com/kotlin) - Most of the Android community uses Kotlin as their preferred choice of language.
- Jetpack:
    - [Jetpack Compose](https://developer.android.com/jetpack/compose) - Jetpack Compose is Android’s modern toolkit for building native UI. It simplifies and accelerates UI development on Android. Quickly bring your app to life with less code, powerful tools, and intuitive Kotlin APIs.
    - [Android KTX](https://developer.android.com/kotlin/ktx.html) - Android KTX is a set of Kotlin extensions that are included with Android Jetpack and other Android libraries. KTX extensions provide concise, idiomatic Kotlin to Jetpack, Android platform, and other APIs.
    - [AndroidX](https://developer.android.com/jetpack/androidx) - The androidx namespace comprises the Android Jetpack libraries. It's a major improvement to the original Android [Support Library](https://developer.android.com/topic/libraries/support-library/index), which is no longer maintained.
    - [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - Lifecycle-aware components perform actions in response to a change in the lifecycle status of another component, such as activities and fragments. These components help you produce better-organized, and often lighter-weight code, that is easier to maintain.
    - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - The ViewModel class is a business logic or screen level state holder. It exposes state to the UI and encapsulates related business logic. Its principal advantage is that it caches state and persists it through configuration changes.
- [Dagger Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - A dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in your project.
- [Kotlin Coroutines](https://developer.android.com/kotlin/coroutines) - A concurrency design pattern that you can use on Android to simplify code that executes asynchronously and it's the recommended way for asynchronous programming on Android.
- [Kotlin Flow](https://developer.android.com/kotlin/flow) - In coroutines, a flow is a type that can emit multiple values sequentially, as opposed to suspend functions that return only a single value.
- [Retrofit](https://square.github.io/retrofit) - Retrofit is a REST client for Java/ Kotlin and Android by Square. Its a simple network library that is used for network transactions.
- [OkHttp](https://github.com/square/okhttp) - OkHttp is an HTTP client. It perseveres when the network is troublesome as it will silently recover from common connection problems.
- [GSON](https://github.com/google/gson) - JSON Parser, used to parse requests on the data layer for Entities and understands Kotlin non-nullable and default parameters.
- [Logging Interceptor](https://github.com/square/okhttp/blob/master/okhttp-logging-interceptor/README.md) - An OkHttp interceptor which logs HTTP request and response data.
- [Coil](https://coil-kt.github.io/coil/compose/)- An image loading library for Android backed by Kotlin Coroutines.
- [Timber](https://github.com/JakeWharton/timber)- A logger with a small, extensible API which provides utility on top of Android's normal Log class.
- [Mockk](https://github.com/mockk/mockk)- A mocking library for Kotlin
- [Turbine](https://github.com/cashapp/turbine)- A small testing library for kotlinx.coroutines Flow

## 📱 Screenshots

<img src="https://github.com/aishwarya-kamal/Weather/assets/31899200/c123c440-06c0-4712-9910-b99423283882" width="40%"/></a>
<img src="https://github.com/aishwarya-kamal/Weather/assets/31899200/82e932c2-9b47-4c84-85ad-f500c9056987" width="40%"/></a>

## Demo

https://github.com/aishwarya-kamal/Weather/assets/31899200/57aadb97-dab4-4d0f-90b8-297c19611ca2

https://github.com/aishwarya-kamal/Weather/assets/31899200/ddf2cd97-d291-42e7-bdcc-ca8c2c02e0e9

https://github.com/aishwarya-kamal/Weather/assets/31899200/2f3f5ae3-16b4-4153-99c0-fd0149a3ecc7

https://github.com/aishwarya-kamal/Weather/assets/31899200/00c25c6d-9990-41d7-abaf-128f169fd7cd




