# lightning-client
This Android App shows the top hundred lightning nodes

## Build tools & versions used
This project is an Android application developed using Android Studio, Kotlin DSL gradle build and Android compileSdk 35. 
The build system used is Gradle.

## Steps to run the app
1. Clone the repository to your local machine.
2. Open the project in Android Studio.
3. Sync the gradle files.
4. Build and run the application on an emulator or a physical device.

## What areas of the app did you focus on?
I focused on implementing a clean architecture structure to make it possible to run tests. The key areas include:
- Proper data flow using coroutines and Flow.
- Repository and data source patterns.
- UI components using Jetpack Compose.
- Unit tests for repository and data source modules.

## What was the reason for your focus? What problems were you trying to solve?
The primary goal was to ensure that the app is well-structured, modular, and easy to maintain.

## How long did you spend on this project?
I spent approximately 5 hours on this project, including implementation and testing.

## Did you make any trade-offs for this project? What would you have done differently with more time?
With more time to develop I would have created many instrumented tests and converted the data and domain modules into pure library modules (without the android scope).

## What do you think is the weakest part of your project?
Lack of detailed previews of jetpack compose components and specific tests in the api consumption layer.

