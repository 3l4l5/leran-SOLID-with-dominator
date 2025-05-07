plugins {
    // 既存
    kotlin("jvm") version "2.1.10"

    // ★ 自動 apply を無効化
    id("fr.pierrickrouxel.prettier") version "1.0.2" apply false
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

// Kotlin/JVM のターゲット
kotlin {
    jvmToolchain(23)
}
