plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.5.0"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "gwjang"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.redisson:redisson-spring-boot-starter:3.50.0")
    implementation("org.springframework.boot:spring-boot-starter-aop")
    implementation("org.springframework:spring-expression")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    implementation("org.hibernate.validator:hibernate-validator:8.0.0.Final")
    implementation("org.hibernate:hibernate-envers:6.6.8.Final")
    implementation("org.hibernate:hibernate-spatial:6.6.8.Final")
    runtimeOnly("org.postgresql:postgresql")
    implementation("net.postgis:postgis-jdbc:2021.1.0")
    testImplementation("com.ninja-squad:springmockk:4.0.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(module = "mockito-core")
    }
    testImplementation("io.kotest:kotest-runner-junit5:5.6.0")
    testImplementation("io.kotest:kotest-assertions-core:5.6.0")
    testImplementation("io.kotest:kotest-property:5.6.0")
    testImplementation("io.kotest:kotest-framework-datatest:5.6.0")
    testImplementation("io.kotest.extensions:kotest-extensions-spring:1.1.3")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
