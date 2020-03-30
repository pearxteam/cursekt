rootProject.name = "cursekt"

pluginManagement {
    val multigradleVersion: String by settings
    val kotlinVersion: String by settings
    val githubReleaseVersion: String by settings

    plugins {
    	kotlin("multiplatform") version kotlinVersion
        kotlin("plugin.serialization") version kotlinVersion
        id("net.pearx.multigradle.simple.project") version multigradleVersion
        id("com.github.breadmoirai.github-release") version githubReleaseVersion
    }
}