/*
 * Designed and developed by Ji Sungbin, 2023
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/sungbinland/conference-web-template
 */

@file:Suppress("DSL_SCOPE_VIOLATION")

import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension

plugins {
    kotlin("multiplatform") version libs.versions.kotlin.core
    alias(libs.plugins.compose.core)
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
                implementation(compose.web.core)
                implementation(compose.runtime)
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(libs.test.kotlin)
                implementation(compose.web.testUtils)
            }
        }
    }
}

// a temporary workaround for a bug in jsRun invocation
// see https://youtrack.jetbrains.com/issue/KT-48273
afterEvaluate {
    rootProject.extensions.configure<NodeJsRootExtension> {
        versions.webpackDevServer.version = "4.0.0"
        versions.webpackCli.version = "4.10.0"
    }
}
