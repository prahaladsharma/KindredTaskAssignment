
* In this assignment i am focus only on code structure not UI.


## Code explain

Code Explain:-
Model:-     Game.java, WishesV94mg.java, SubVendor.java, TypeSettings.java, Vendor.java <br/>
View:-      GamesListActivity.java  <br/>
ViewModel:- GamesListViewModel.java <br/>

Step1:- GamesListActivity will call ViewModel(GamesListViewModel)<br/>
Step2:- ViewModel(GamesListViewModel) will call Repository(AppRepositoryImpl)<br/>
           -> In repository we have to decide that we are calling local DB or remote API<br/>
           -> So in this assignment we calling network API<br/>
Step3:- Repository will remote data source(RemoteDataSourceImpl)<br/>
Step4:- Remote Source will call api service(ApiService)<br/>

<b>Very Imp</b><br/>
<ul>
<li>In this assignment, API response is so complicated, in response there are lot of objects(1849).\
   So we can't create lot of POJO class. So in this assignment i am creating POJO classes at run time.
   And after that i parse this assignment dynamically.</li>

<ul>
-> In this assignment, API response is so complicated, in response there are lot of objects(1849).\
   So we can't create lot of POJO class. So in this assignment i am creating POJO classes at run time.
   And after that i parse this assignment dynamically.


----------------------------------------------------------------------------------------------------
Features Enhancement:-
-> We can improve UI more better way.
-> We can write more Unit cases.

        

# Screenshots

<p align="center">
  <img src="https://user-images.githubusercontent.com/6931557/156621638-9efe364c-29fd-4e02-b6b9-fcdcd5434133.png" width="150" title="hover text">
</p>

# Built With <g-emoji class="g-emoji" alias="hammer_and_wrench" fallback-src="https://github.githubassets.com/images/icons/emoji/unicode/1f6e0.png">🛠</g-emoji>

<ul>
<li><a href="https://kotlinlang.org/" rel="nofollow">Kotlin</a> - First class and official programming language for Android development.</li>
<li><a href="https://kotlinlang.org/docs/reference/coroutines-overview.html" rel="nofollow">Coroutines</a> - For asynchronous</li>
<li><a href="https://developer.android.com/topic/libraries/architecture" rel="nofollow">Android Architecture Components</a> - Collection of libraries that help you design robust, testable, and maintainable apps.
<ul>
<li><a href="https://developer.android.com/topic/libraries/architecture/livedata" rel="nofollow">LiveData</a> - Data objects that notify views when the underlying database changes.</li>
<li><a href="https://developer.android.com/topic/libraries/architecture/viewmodel" rel="nofollow">ViewModel</a> - Stores UI-related data that isn't destroyed on UI changes.</li>
<li><a href="https://developer.android.com/topic/libraries/view-binding" rel="nofollow">ViewBinding</a> - Generates a binding class for each XML layout file present in that module and allows you to more easily write code that interacts with views.</li>
</ul>
</li>
<li><a href="https://insert-koin.io/" rel="nofollow">Koin</a> - Dependency Injection Framework</li>
<li><a href="https://square.github.io/retrofit/" rel="nofollow">Retrofit</a> - A type-safe HTTP client for Android and Java.</li>
<li><a href="https://github.com/google/gson">GSON</a> - A Java serialization/deserialization library to convert Java Objects into JSON and back.</li>
<li><a href="https://github.com/square/retrofit/tree/master/retrofit-converters/gson">GSON Converter</a> - A Converter which uses Gson for serialization to and from JSON.</li>
<li><a href="https://github.com/square/okhttp">OkHttp3</a> -  For implementing interceptor, logging and mocking web server.</li>
<li><a href="https://github.com/material-components/material-components-android">Material Components for Android</a> - Modular and customizable Material Design UI components for Android.</li>
</ul>

# Architecture
This app uses [MVVM Model View View-Model](https://developer.android.com/jetpack/guide#recommended-app-arch) architecture.

![mvvm_architecture](https://user-images.githubusercontent.com/6931557/124789778-69eb7f00-deff-11eb-9382-2936c6ac9e2f.png)
