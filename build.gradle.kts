val ktor_version = "2.2.4"
val kotlin_bom = "1.8.20"
val kotlin_stdlib = "1.8.20"
val kotlinx_coroutines_javafx = "1.6.4"
val kotlinx_serialization = "1.5.0"
val javafx_controls = "20"
val tornadofx = "1.7.20"
val junit_jupiter_api = "5.9.2"
val kotlin_test = "1.8.20"

group = "com.madsky"
version = "1.0-SNAPSHOT"

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {kotlinOptions.jvmTarget = "1.8"}

repositories {
    mavenCentral()
}

plugins {
    kotlin("jvm") version "1.8.20-RC2"
    kotlin("plugin.serialization") version "1.6.0"
    id("org.openjfx.javafxplugin") version "0.0.8"
    application
    java
}

javafx {
    version = "11"
    modules = listOf("javafx.controls", "javafx.fxml", "javafx.graphics")
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom:$kotlin_bom"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlin_stdlib")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin_stdlib")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-javafx:$kotlinx_coroutines_javafx")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:$kotlinx_serialization")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinx_serialization")

    implementation("org.openjfx:javafx-controls:$javafx_controls")
    implementation("no.tornado:tornadofx:$tornadofx")

    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-json:$ktor_version")
    implementation("io.ktor:ktor-client-serialization:$ktor_version")
    implementation("io.ktor:ktor-client-cio:$ktor_version")
    implementation("io.ktor:ktor-client-content-negotiation:$ktor_version")
    implementation("io.ktor:ktor-client-serialization:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-xml:$ktor_version")
    implementation("io.ktor:ktor-client-logging:$ktor_version")

    implementation("ch.qos.logback:logback-classic:1.4.6")

    testImplementation("org.junit.jupiter:junit-jupiter-api:$junit_jupiter_api")
    testImplementation("org.jetbrains.kotlin:kotlin-test:$kotlin_test")
}

tasks.test {useJUnitPlatform()}
kotlin {jvmToolchain(8)}
application {mainClass.set("MainKt")}