/**
* In this assignment i am focus only on code structure not UI.
*/

## Code explain

##Project Tech Stack
Architecture:-  MVVM
DI:-   Dragger
Language:-Kotlin
Coroutines - For asynchronous
LiveData - Data objects that notify views when the underlying database changes.
ViewModel - Stores UI-related data that isn't destroyed on UI changes.
ViewBinding - Generates a binding class for each XML layout file present in that module and allows you to more easily write code that interacts with views.
Retrofit - A type-safe HTTP client for Android and Java.
GSON - A Java serialization/deserialization library to convert Java Objects into JSON and back.
GSON Converter - A Converter which uses Gson for serialization to and from JSON.
OkHttp3 - For implementing interceptor, logging and mocking web server.
Material Components for Android - Modular and customizable Material Design UI components for Android.

----------------------------------------------------------------------------------------------------
Code Explain:-
Model:-     Game.java, WishesV94mg.java, SubVendor.java, TypeSettings.java, Vendor.java
View:-      GamesListActivity.java
ViewModel:- GamesListViewModel.java

Step1:- GamesListActivity will call ViewModel(GamesListViewModel)
Step2:- ViewModel(GamesListViewModel) will call Repository(AppRepositoryImpl)
           -> In repository we have to decide that we are calling local DB or remote API
           -> So in this assignment we calling network API
Step3:- Repository will remote data source(RemoteDataSourceImpl)
Step4:- Remote Source will call api service(ApiService)

Very Imp:-----------------------------------
-> In this assignment, API response is so complicated, in response there are lot of objects(1849).\
   So we can't create lot of POJO class. So in this assignment i am creating POJO classes at run time.
   And after that i parse this assignment dynamically.


----------------------------------------------------------------------------------------------------
Features Enhancement:-
-> We can improve UI more better way.
-> We can write more Unit cases.
