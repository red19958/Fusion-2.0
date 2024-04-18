plugins {
    kotlin("android")
    id("com.android.library")
}

kotlin {
    sourceSets {
        dependencies {
            implementation(libs.kotlin.stdlib)
            implementation(libs.activityCompose)
            val composeBom =
                project.dependencies.platform("androidx.compose:compose-bom:2024.02.01")
            implementation(composeBom)
            implementation(libs.material3)
            implementation(libs.glideCompose)
            implementation(libs.appcompat)
            implementation(libs.ktxCoreAndroid)
            implementation(libs.antlr4Runtime)
        }
    }
}

android {
    namespace = "com.fusion.state"
    compileSdk = 34

    buildFeatures {
        buildConfig = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.10"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

val sourceJar by tasks.registering(Jar::class) {
    from(android.sourceSets.getByName("main").java.srcDirs)
    archiveClassifier.set("sources")
}