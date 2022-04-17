
# 📱 [ExhibitListApp](https://github.com/timmyCoder/ExhibitListApp/blob/master/app-debug.apk) 

This is a Single Activity android application that showcases a list of different types of iPhones from a server db. The application allows user to see a list of iPhones with different models and their respective available images. The application consumes
the [Reyst exhibit_db API](https://my-json-server.typicode.com/Reyst/exhibit_db/list) and also provides offline accessibility to view the data gotten from the server.


- Minimum Api Level : 21
- compileSdkVersion : 32
- Build System | Version : [Gradle](https://gradle.org/) | 7.1.2

## :scroll: Architecture Overview 
The app uses the MVVM Clean architecture approach which assumes separation of concerns with UI(Activity, Fragment, View), Presentation(ViewModel), Domain(Entities, Models) and Data(Repository) layers. 

<img src="https://developer.android.com/topic/libraries/architecture/images/final-architecture.png" width=500/>
<br>

### 💡 viewModel helps to handle user interaction, save current state of app and automatically manage Android UI components lifecycle via LiveData.


The Application is split into a three layer architecture:

- Data
- Domain
- Presentation

#### Data

The data layer handles the business logic and provides data from the
Reyst exhibit_db API and a local database leveraging Room. This layer uses the 
Repository pattern which serves as data point, where ViewModel knows nothing about source of data. 
It is up to repository to decide whether local or remote data should be given back to user. 
This serves well to handle data synchronisation conflicts.


#### Domain

The domain layer contains the application specifics logic. It also contains models used to aid the data layer with 
actions performed in it and also displaying of data in the presentation layer


#### Presentation

MVVM pattern is used for the presentation layer. With the use of ViewModel and LiveData lifecycle awareness, the 
```MainViewModel``` is very simple. It has only ```ExhibitRepository``` as a dependency in order to provide data.


### Supporting offline caching

This project supports offline caching using [ROOM](https://developer.android.com/training/data-storage/room) where I avoid synchronisation discrepancies by defining a single source of truth. The Repository serves as an abstract source of data for Presentation Layer (viewModel) and should decide which data source is truth. This is however done by defining a local database as a source of truth. Whenever data is requested a local copy is presented, then the remote data is fetched and saved to database, which will automatically notify Repository about any new data available.

The offline caching provided by room is supported by using the ```NetworkBoundResource``` algorithm as well. This algorithm only requires using the subclass of the NetworkBoundResource and override a few methods, usually requiring only a few lines of code.
While the algorithm handled loading, success, and error network states, its intended use case is only for devices in online mode. 

<img src="https://user-images.githubusercontent.com/36578083/163714871-f771b5b3-c420-4c3b-be80-8e8e61f72b92.png" width=500/>


## 🧰 Libraries

Libraries used in the application are:

- [Jetpack](https://developer.android.com/jetpack)
  - [Viewmodel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Manage UI related data with lifecycle awareness.
  - [Room](https://developer.android.com/training/data-storage/room) - Provides abstraction layer over SQLite, and used as offline support.
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Used for lifecycle aware and observing data for any new changes.
- [Retrofit](https://square.github.io/retrofit/) - Type safe http client and supports coroutines out of the box.
- [Shimmer](https://facebook.github.io/shimmer-android/) - Shimmer provides an easy way to add a shimmer effect to views in the application.
- [Glide](https://github.com/bumptech/glide) - Used to load images in real time and also when cached
- [Moshi](https://github.com/square/moshi) - A modern JSON library for Kotlin and Java..
- [kotlinx.coroutines](https://github.com/Kotlin/kotlinx.coroutines) - Library Support for coroutine flows. This uses suspend functions to produce and consume values asynchronously.
- [kotlin Flows](https://developer.android.com/kotlin/flow) - Library Support for coroutines. I used this for asynchronous programming in order
- [JUnit](https://junit.org/junit4/) - This was used for unit testing the repository, the use cases and the ViewModels.
- [Mockito](https://developer.android.com/training/testing/unit-testing/local-unit-tests) This is a mocking library for Kotlin.
- [Hilt](https://dagger.dev/hilt/) - Dependency injection plays a central role in the architectural pattern used.
And to not over engineer things, I have chosen Hilt which is built on top of the DI framework - Dagger 2.

## ⚙ Testing

Unit Tests are available, as well as Instrumentation tests. I have made effort to try to make the tests pass, but I think i can double down on it better

## ‼️ 

My implementation with storing the data gotten from the API in the local db, and as well retrieving it from the local db is an efficient one because I have ensured to tackle data redundancy using the ROOM ```onConflict = OnConflictStrategy.REPLACE```
whilst saving the data.

### but there's more from where this came 😎

## 🎥 Demo

https://user-images.githubusercontent.com/36578083/163715448-8240e4df-3e74-4df6-86c7-4f1579650eff.mov


