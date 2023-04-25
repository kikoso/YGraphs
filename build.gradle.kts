buildscript {

    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }

    dependencies {
        classpath("com.android.tools.build:gradle:7.4.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.21")
        classpath("org.jetbrains.kotlin:kotlin-android-extensions:1.8.21")
        classpath("org.jetbrains.dokka:dokka-gradle-plugin:1.7.20")
    }

    tasks {
        register("clean", Delete::class) {
            delete(rootProject.buildDir)
        }
    }
}
