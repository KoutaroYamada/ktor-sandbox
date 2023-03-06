val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    kotlin("jvm") version "1.8.10"
    id("io.ktor.plugin") version "2.2.4"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.8.10"
    id("org.flywaydb.flyway") version "9.15.1"
}

group = "com.example"
version = "0.0.1"
application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.flywaydb:flyway-mysql:9.15.1")
    }
}
flyway {
    url = "jdbc:mysql://localhost:3306/db"
    user = "user"
    password = "password"
    locations = arrayOf("filesystem:db/migration")
}


dependencies {
    testImplementation("io.ktor:ktor-server-tests-jvm:2.2.4")
    testImplementation("io.ktor:ktor-client-content-negotiation:2.2.4")
    testImplementation("io.kotest:kotest-runner-junit5:5.5.5")
    testImplementation("io.kotest.extensions:kotest-assertions-ktor:1.0.3")
    testImplementation("io.mockk:mockk:1.13.4")
    implementation("io.ktor:ktor-server-core-jvm:2.2.4")
    implementation("io.ktor:ktor-server-content-negotiation-jvm:2.2.4")
    implementation("io.ktor:ktor-serialization-jackson-jvm:2.2.4")
    implementation("io.ktor:ktor-server-netty-jvm:2.2.4")
    implementation("io.ktor:ktor-server-status-pages:2.2.4")
    implementation("io.ktor:ktor-server-host-common-jvm:2.2.4")
    implementation("io.ktor:ktor-server-status-pages-jvm:2.2.4")
    implementation("io.ktor:ktor-server-call-id:2.2.4")
    implementation("io.ktor:ktor-server-call-logging:2.2.4")
    implementation("io.ktor:ktor-server-call-logging-jvm:2.2.4")
    implementation("org.jetbrains.exposed:exposed-core:0.41.1")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.41.1")
    implementation("org.jetbrains.exposed:exposed-java-time:0.41.1")
    implementation("mysql:mysql-connector-java:8.0.32")
    implementation("com.zaxxer:HikariCP:4.0.3")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.14.2")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-csv:2.14.2")
    implementation("io.insert-koin:koin-ktor:3.3.0")
    implementation("io.insert-koin:koin-logger-slf4j:3.3.0")
    implementation("org.slf4j:slf4j-api:2.0.6")
    implementation("ch.qos.logback:logback-classic:1.4.5")
    implementation("io.github.microutils:kotlin-logging-jvm:3.0.5")
}
