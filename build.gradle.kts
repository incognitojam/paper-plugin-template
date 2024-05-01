plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.shadow)
    alias(libs.plugins.paperweight)
    alias(libs.plugins.run.paper)
}

group = "dev.incognitojam"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://repo.flyte.gg/releases")
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    paperweight.paperDevBundle("1.20.4-R0.1-SNAPSHOT")

    implementation(libs.twilight)
    implementation(libs.paperlib)

    implementation(libs.lamp.common)
    implementation(libs.lamp.bukkit)
    implementation(libs.lamp.brigadier)
}

tasks {
    build { dependsOn(shadowJar) }

    shadowJar {
        relocate("kotlin", "dev.incognitojam.kotlin")
        relocate("io.papermc.lib", "dev.incognitojam.paperlib")
        relocate("org.jetbrains.annotations", "dev.incognitojam.jetbrains.annotations")
        relocate("org.intellij.lang.annotations", "dev.incognitojam.intellij.lang.annotations")
    }

    runServer { minecraftVersion("1.20.4") }
}

kotlin {
    jvmToolchain(21)
}
