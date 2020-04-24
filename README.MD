# CurseKT [![Maven Central](https://img.shields.io/maven-central/v/net.pearx.cursekt/cursekt-metadata.svg?label=common&logo=kotlin&logoColor=white)](https://search.maven.org/search?q=g:%22net.pearx.cursekt%22%20AND%20a:%22cursekt-metadata%22) [![Maven Central](https://img.shields.io/maven-central/v/net.pearx.cursekt/cursekt-jvm.svg?label=jvm&logo=java&logoColor=white)](https://search.maven.org/search?q=g:%22net.pearx.cursekt%22%20AND%20a:%22cursekt-jvm%22) [![Maven Central](https://img.shields.io/maven-central/v/net.pearx.cursekt/cursekt-js.svg?label=js&logo=javascript&logoColor=white)](https://search.maven.org/search?q=g:%22net.pearx.cursekt%22%20AND%20a:%22cursekt-js%22)
[![License](https://img.shields.io/github/license/pearxteam/cursekt.svg)](https://raw.githubusercontent.com/pearxteam/cursekt/master/LICENSE.TXT)
[![Discord](https://img.shields.io/discord/136085738151346176.svg?logo=discord&logoColor=white)](https://discord.gg/q9cX9QE)
[![Release Build Status](https://img.shields.io/jenkins/build/https/ci.pearx.net/job/pearxteam/job/cursekt/job/master.svg?label=build%20%5Bmaster%5D&logo=jenkins&logoColor=white)](https://ci.pearx.net/job/pearxteam/job/cursekt/job/master/)
[![Develop Build Status](https://img.shields.io/jenkins/build/https/ci.pearx.net/job/pearxteam/job/cursekt/job/develop.svg?label=build%20%5Bdevelop%5D&logo=jenkins&logoColor=white)](https://ci.pearx.net/job/pearxteam/job/cursekt/job/develop/)

Multiplatform **Kotlin** library to work with the **Curse (CurseForge) API** using **Ktor**.

# Setup
1. Add the lib to your project's dependencies by copying one of the following lines depending on the platform:
- **Groovy** (replace `$cursekt_version` with the version you want):
```groovy
 implementation "net.pearx.cursekt:cursekt-metadata:$cursekt_version" // for Common
 // or
 implementation "net.pearx.cursekt:cursekt-jvm:$cursekt_version" // for JVM
 // or
 implementation "net.pearx.cursekt:cursekt-js:$cursekt_version" // for JS
```
- **Kotlin** (replace `$cursektVersion` with the version you want):
```kotlin
 implementation("net.pearx.cursekt:cursekt-metadata:$cursektVersion") // for Common
 // or
 implementation("net.pearx.cursekt:cursekt-jvm:$cursektVersion") // for JVM
 // or
 implementation("net.pearx.cursekt:cursekt-js:$cursektVersion") // for JS
```

2. CurseKT uses coroutines! Ensure you've added **kotlinx.coroutines** as a dependency: https://github.com/Kotlin/kotlinx.coroutines#using-in-your-projects.

3. Don't forget to declare the **JCenter** Maven repository to your build script (required by Ktor):
```kotlin
repositories {
    jcenter()
}
```

4. Use the library and have fun!

# How to Use the Library
You can get a brief example of how to work with the library at the [Example Application](#example-application) section. To get all the methods available in CurseKT, take a look at the [CurseClient.kt](src/commonMain/kotlin/net/pearx/cursekt/client/CurseClient.kt) file.

# Example Application
This application will search for Minecraft 1.15.2 mods matching the "just enough items" filter, sort by download count and print them.
```kotlin
import kotlinx.coroutines.runBlocking
import net.pearx.cursekt.client.CurseClient

fun main() {
    runBlocking {
        val curse = CurseClient() // create a new CurseClient instance
        val minecraftGame = curse.getGames(supportsAddons = true).first { it.slug == "minecraft" } // get Minecraft game
        val modsSection = minecraftGame.categorySections.first { it.name == "Mods" } // get Minecraft Mods section
        val addons = curse.searchAddons(gameId = minecraftGame.id, sectionId = modsSection.gameCategoryId, gameVersion = "1.15.2", searchFilter = "just enough items") // search for Minecraft 1.15.2 mods matching the "just enough items" filter
        val addonsSorted = addons.sortedByDescending { it.downloadCount } // sort search results by download count
        println(addonsSorted.joinToString(System.lineSeparator()) { "${it.name} - ${it.downloadCount.toInt()}" }) // print sorted search results
    }
}
```