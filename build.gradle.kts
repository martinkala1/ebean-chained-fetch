plugins {
    val kotlinVersion = "2.0.20"
    kotlin("jvm") version kotlinVersion
    id("io.ebean") version "15.11.0" apply true
    id("idea")
    kotlin("kapt") version kotlinVersion apply true
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:2.0.20")
//    implementation("org.avaje.composite:logback:1.1")

    implementation("io.ebean:ebean:15.11.0")
    implementation("org.postgresql:postgresql:42.7.2")

    kapt("io.ebean:kotlin-querybean-generator:15.11.0")

    testImplementation("io.ebean:ebean-test:15.11.0")
    testImplementation("io.avaje:junit:1.1")
}
tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}
