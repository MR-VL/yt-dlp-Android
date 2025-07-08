buildscript {
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://chaquo.com/maven")
        }
    }
    dependencies {
        classpath("com.chaquo.python:gradle:14.0.2")
    }
}

plugins {
    // You can keep this for android and kotlin plugin versions or remove if managed in app module
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
}
