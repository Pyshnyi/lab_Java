group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
dependencies {
    // TestNG
    testImplementation("org.testng:testng:7.10.2")

    // SLF4J API
    implementation("org.slf4j:slf4j-api:2.0.7")

    // Logback implementation
    implementation("ch.qos.logback:logback-classic:1.4.11")
    implementation(kotlin("stdlib"))
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.15.0")  // Для JSON анотацій
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.0")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.15.0")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.15.0")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.15.0")
}

tasks.test {
    useTestNG()
}
plugins {
    kotlin("jvm") version "1.8.0"
    id("application")
    id("java")
}

application {
    mainClass.set("lab3.Main")
}
