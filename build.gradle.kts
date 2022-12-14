// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id ("com.android.application") version "7.3.1" apply false
    id ("com.android.library") version "7.3.1" apply false
    id ("org.jetbrains.kotlin.android") version "1.7.20" apply false
    //navigation
    id ("androidx.navigation.safeargs.kotlin") version "2.5.2" apply false
    //hilt
    id ("com.google.dagger.hilt.android") version "2.42" apply false
}