## Minimum

*This branch contains the application using MVP architecture.  
See the other versions of application in the appropriate git branches.*

This is the Android application written without IDE, in a simple text editor and compiled in command line.
Its goal is to understand how to create Android application from scratch, its structure, and necessary tools.

This feature of the project is based on [this article on Russian](https://habrahabr.ru/post/210584/) and [this article on English](http://geosoft.no/development/android.html).

Please see other branches to repeat this no-IDE approach.

Also the app uses simplest implementation of MVP (Model — View — Presenter) architecture. This feature is explained in [this article of Antonio Leiva](https://antonioleiva.com/mvp-android/).

All binary output files are kept in the repo to let you completely understand the project.

### Project structure

```
│   AndroidManifest.xml
├───bin
├───obj
├───res
│   ├───layout
│   │       activity_main.xml
│   │       activity_pin.xml
│   └───values
│           strings.xml
│
└───src
    └───ru
        └───coffeeplanter
            └───minimum
                ├───login
                │       PinActivity.java
                │       PinInteractor.java
                │       PinInteractorImpl.java
                │       PinPresenter.java
                │       PinPresenterImpl.java
                │       PinView.java
                └───main
                        LoadItemsInteractor.java
                        LoadItemsInteractorImpl.java
                        MainActivity.java
                        MainPresenter.java
                        MainPresenterImpl.java
                        MainView.java
```

### Screenshot
![Screenshot](/screenshot.png?raw=true "Screenshot")
