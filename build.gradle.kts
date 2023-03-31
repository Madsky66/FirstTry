plugins {
    java
    kotlin("jvm") version "1.8.0"
    id("org.openjfx.javafxplugin") version "0.0.8"
    application
}

group = "com.madsky"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {kotlinOptions.jvmTarget = "1.8"}

javafx {
    version = "11.0.2"
    modules = listOf("javafx.controls", "javafx.fxml", "javafx.graphics")
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation(kotlin("stdlib-jdk8"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-javafx:1.5.2")
    implementation("org.openjfx:javafx-controls:19.0.2.1")
    implementation("no.tornado:tornadofx:1.7.20")

    implementation("org.graphstream:gs-core:2.0")

    testImplementation("junit:junit:4.13.2")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}