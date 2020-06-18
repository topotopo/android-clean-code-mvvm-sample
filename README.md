# clean-code-mvvm-sample
This is a sample app that uses clean-code, mvvm architecture. 
## Main features
1. List of top github repository  
***PLEASE READ!***
  *To demonstrate an api call, this screen fetches a list of github repositories. Please refer to API [document](https://githubtrendingapi.docs.apiary.io/#reference/0/repositories/list-trending-repositories). Swiping the page will refresh the list from the server and will delete any update done locally. This is done for demonstration purposes only. **Details and Edit Page has no API calls***
2. Details Page
3. Edit Page
### Tech
This app used a number of Jetpack components and other 3rd Party libraries. Here are a few libraries used in the app.
##### UI
* [Glide](https://github.com/bumptech/glide) - Image loading and caching
* [Shimmer](https://github.com/facebook/shimmer-android) - Shimmering effect for loading views
* [Common Recyclerview Adapter](https://github.com/topotopo/Common-RecyclerViewAdapter-Android) - created by author to avoid boilerplate code when creating lists. Please see code in link provided.
##### Service
* [Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android
* [Hilt](https://dagger.dev/hilt/) - Dependency Injection library built on top of dagger made specifically to incorporate with Android.
##### Persistent Storage
* [Room](https://developer.android.com/jetpack/androidx/releases/room) - persistent storage library on top of SQLite
##### Jetpack Componnets
* Activity/Fragments, Livedata, Databinding, Room, Hilt
## Todo
List of improvements / Refactoring that can be done.
* More unit testing coverage for usecase/interactors
* UI Testing
* Styling of UI components
* ...
## Authors
```Maxine Micu, maxine.micu@gmail.com```
