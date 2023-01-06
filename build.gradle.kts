/*
 * Designed and developed by Ji Sungbin, 2023
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/sungbinland/conference-web-template
 */

@file:Suppress("DSL_SCOPE_VIOLATION")

plugins {
    kotlin("multiplatform") version libs.versions.kotlin.core
    alias(libs.plugins.code.ktlint)
    alias(libs.plugins.code.detekt)
}

group = "day.sungbinland"
version = "master"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

detekt {
    parallel = true
    buildUponDefaultConfig = true
    toolVersion = libs.versions.code.detekt.get()
    config.setFrom(files("$rootDir/detekt-config.yml"))
}

ktlint {
    version.set(rootProject.libs.versions.code.ktlint.source.get())
    outputToConsole.set(true)
    additionalEditorconfigFile.set(file("$rootDir/.editorconfig"))
}

kotlin {
    js(IR) {
        browser()
        binaries.executable()
    }

    @Suppress("UNUSED_VARIABLE")
    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(libs.compose.runtime)
                implementation(libs.compose.web.core)
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(libs.test.kotlin)
                implementation(libs.test.compose.web.utils)
            }
        }
    }
}
