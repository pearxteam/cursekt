import com.github.breadmoirai.githubreleaseplugin.GithubReleaseExtension
import net.pearx.multigradle.util.MultiGradleExtension
import net.pearx.multigradle.util.kotlinMpp

val projectChangelog: String by project
val projectDescription: String by project

val pearxRepoUsername: String? by project
val pearxRepoPassword: String? by project
val sonatypeOssUsername: String? by project
val sonatypeOssPassword: String? by project
val githubAccessToken: String? by project
val devBuildNumber: String? by project

val ktorVersion: String by project
val kotlinxSerializationVersion: String by project

plugins {
    id("net.pearx.multigradle.simple.project")
    kotlin("multiplatform") apply (false)
    id("com.github.breadmoirai.github-release")
    kotlin("plugin.serialization")
    `maven-publish`
    signing
}

group = "net.pearx.cursekt"
description = projectDescription

kotlinMpp {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-serialization:$ktorVersion")
                implementation("io.ktor:ktor-client-json:$ktorVersion")
                implementation("io.ktor:ktor-client-core:$ktorVersion")
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-serialization-jvm:$ktorVersion")
                implementation("io.ktor:ktor-client-json-jvm:$ktorVersion")
                implementation("io.ktor:ktor-client-cio:$ktorVersion")
            }
        }
        val jsMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-serialization-js:$ktorVersion")
                implementation("io.ktor:ktor-client-json-js:$ktorVersion")
                implementation("io.ktor:ktor-client-js:$ktorVersion")
            }
        }
    }
}

configure<MultiGradleExtension> {
    if (devBuildNumber != null) {
        projectVersion = "$projectVersion-dev-$devBuildNumber"
    }
}

configure<PublishingExtension> {
    publications.withType<MavenPublication> {
        pom {
            name.set(artifactId)
            description.set(projectDescription)
            url.set("https://github.com/pearxteam/cursekt")
            licenses {
                license {
                    name.set("Mozilla Public License, Version 2.0")
                    url.set("https://mozilla.org/MPL/2.0/")
                    distribution.set("repo")
                }
            }
            organization {
                name.set("PearX Team")
                url.set("https://pearx.net/")
            }
            developers {
                developer {
                    id.set("mrAppleXZ")
                    name.set("mrAppleXZ")
                    email.set("me@pearx.net")
                    url.set("https://pearx.net/members/mrapplexz")
                    organization.set("PearX Team")
                    organizationUrl.set("https://pearx.net/")
                    roles.set(listOf("developer"))
                    timezone.set("Asia/Yekaterinburg")
                }
            }
            scm {
                url.set("https://github.com/pearxteam/cursekt")
                connection.set("scm:git:git://github.com/pearxteam/cursekt")
                developerConnection.set("scm:git:git://github.com/pearxteam/cursekt")
            }
            issueManagement {
                system.set("GitHub")
                url.set("https://github.com/pearxteam/cursekt/issues")
            }
            ciManagement {
                system.set("Jenkins")
                url.set("https://ci.pearx.net/job/pearxteam/job/cursekt")
            }
        }
    }
    repositories {
        maven {
            credentials {
                username = pearxRepoUsername
                password = pearxRepoPassword
            }
            name = "pearx-repo-develop"
            url = uri("https://repo.pearx.net/maven2/develop/")
        }
        maven {
            credentials {
                username = pearxRepoUsername
                password = pearxRepoPassword
            }
            name = "pearx-repo-release"
            url = uri("https://repo.pearx.net/maven2/release/")
        }
        maven {
            credentials {
                username = sonatypeOssUsername
                password = sonatypeOssPassword
            }
            name = "sonatype-oss-release"
            url = uri("https://oss.sonatype.org/service/local/staging/deploy/maven2/")
        }
    }
}

tasks {
    register("publishDevelop") {
        group = "publishing"
        dependsOn(withType<PublishToMavenRepository>().matching { it.repository.name.endsWith("-develop") })
    }
    register("publishRelease") {
        group = "publishing"
        dependsOn(withType<PublishToMavenRepository>().matching { it.repository.name.endsWith("-release") })
        dependsOn(named("githubRelease"))
    }
}

configure<SigningExtension> {
    sign(publishing.publications)
}

configure<GithubReleaseExtension> {
    setToken(githubAccessToken)
    setOwner("pearxteam")
    setRepo("cursekt")
    setTargetCommitish("master")
    setBody(projectChangelog)
    //setReleaseAssets((publishing.publications["maven"] as MavenPublication).artifacts.map { it.file })
}