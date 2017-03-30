# zBeeApp
Android application using AGA for the zBee car.

## Installation
- Install Android Studio: https://developer.android.com/studio/index.html
- Download AGA SDK: https://developer.lindholmen.se/redmine/projects/aga/wiki/Develop_an_Android_application
- Download AGA simulator: https://developer.lindholmen.se/redmine/projects/aga/wiki/Simulator
- Install git (of course).

## Source code
- Clone the zBeeApp repo: `git clone https://github.com/krmkrl/zBeeApp.git`

## Android studio setup
- Import existing Android Studio project (zBeeApp).
- In SDK Manager, Update "Android SDK Location" to point to the AGA SDK.
- In SDK Manager -> SDK Tools, Install entire support repository (with ConstraintLayout).

## Android Virtual Device
- In AVD Manager, create virtual device, choose "other" and Lollipop 5.0. This is the AGA ROM built from the AGA SDK). It us built for ARM so it is quite slow on x86.

## Run app
- Start the virtual device.
- Press run/play in Android Studio.
- Select the running AVD.

## AGA simulator
- Follow instructions here: https://developer.lindholmen.se/redmine/projects/aga/wiki/Simulator
