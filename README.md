# 🎬 Movie App

A simple and clean Android application built with **Jetpack Compose** and **MVVM architecture**, using the [TMDb API](https://www.themoviedb.org/) to fetch movie data.

This app uses **Retrofit** for network communication and **Room** for local storage — **without any dependency injection framework** like Hilt or Dagger.

---

## 🚀 Features

- ✨ Jetpack Compose UI
- 📡 Fetch movies from TMDb API
- 🧠 MVVM Architecture
- 🔗 Retrofit for network calls
- 💾 Room for local database
- ⚙️ Manual dependency management (no DI)

---

## 🛠 Tech Stack

| Layer           | Technology          |
|----------------|---------------------|
| UI             | Jetpack Compose     |
| Architecture   | MVVM                |
| Networking     | Retrofit + Coroutines |
| Local Storage  | Room (Entity + DAO) |
| State Mgmt     | ViewModel  + mutableStateOf       |

---

## 📂 Project Structure
app/
├── dao/ # Room DAO interfaces
│ └── MovieDao.kt
│
├── repository/ # Repository (data sources)
│ └── MovieRepository.kt
│
├── retrofit/ # API service + Retrofit client
│ ├── ApiService.kt
│ └── RetrofitClient.kt
│
├── screens/ # UI Composable screens
│ └── MovieListScreen.kt
│
├── viewModels/ # ViewModel layer
│ └── MovieViewModel.kt
│
└── MainActivity.kt # App entry point
