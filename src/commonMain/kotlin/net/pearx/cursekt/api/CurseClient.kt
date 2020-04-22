/*
 * Copyright © 2019-2020, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.cursekt.api

import io.ktor.client.HttpClient
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import kotlinx.serialization.json.Json
import net.pearx.cursekt.model.addon.Addon
import net.pearx.cursekt.model.addon.AddonSortMethod
import net.pearx.cursekt.model.addon.FeaturedAddonType
import net.pearx.cursekt.model.addon.file.AddonFile
import net.pearx.cursekt.model.addon.request.FeaturedAddonsRequest
import net.pearx.cursekt.model.category.Category
import net.pearx.cursekt.model.fingerprint.FingerprintMatchResult
import net.pearx.cursekt.model.fingerprint.FolderFingerprint
import net.pearx.cursekt.model.fingerprint.FuzzyFingerprintMatch
import net.pearx.cursekt.model.fingerprint.request.FuzzyMatchesRequest
import net.pearx.cursekt.model.game.Game
import net.pearx.cursekt.model.minecraft.MinecraftVersion
import net.pearx.cursekt.model.minecraft.modloader.ModloaderIndex
import net.pearx.cursekt.model.minecraft.modloader.ModloaderVersion
import net.pearx.cursekt.util.Date
import net.pearx.cursekt.util.DateSerializer

class CurseClient {
    private val http = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
        defaultRequest {
            url.protocol = URLProtocol.HTTPS
            url.host = "addons-ecs.forgesvc.net"
            header("accept", "*/*")
        }
    }

    suspend fun getGames(supportsAddons: Boolean = false): List<Game> {
        return http.get("api/v2/game") {
            parameter("supportsAddons", supportsAddons.toString())
        }
    }

    suspend fun getGame(gameId: Int): Game {
        return http.get("api/v2/game/$gameId")
    }

    suspend fun getGameDatabaseTimestamp(): Date {
        return Json.parse(DateSerializer, http.get("api/v2/game/timestamp"))
    }

    suspend fun getAddon(projectId: Int): Addon {
        return http.get("api/v2/addon/$projectId")
    }

    suspend fun getAddons(projectIds: Collection<Int>): List<Addon> {
        return http.post("api/v2/addon") {
            contentType(ContentType.Application.Json)
            body = projectIds
        }
    }

    suspend fun getAddons(vararg projectIds: Int): List<Addon> = getAddons(projectIds.toList())

    suspend fun getAddonDescription(projectId: Int): String {
        return http.get("api/v2/addon/$projectId/description")
    }

    suspend fun getAddonFiles(projectId: Int): List<AddonFile> {
        return http.get("api/v2/addon/$projectId/files")
    }

    suspend fun getAddonFiles(keys: Collection<Int>): Map<Int, List<AddonFile>> {
        return http.post("api/v2/addon/files") {
            contentType(ContentType.Application.Json)
            body = keys
        }
    }

    suspend fun getAddonFiles(vararg keys: Int): Map<Int, List<AddonFile>> = getAddonFiles(keys.toList())

    suspend fun getAddonFileDownloadUrl(projectId: Int, fileId: Int): String {
        return http.get("api/v2/addon/$projectId/file/$fileId/download-url")
    }

    suspend fun getAddonFile(projectId: Int, fileId: Int): AddonFile {
        return http.get("api/v2/addon/$projectId/file/$fileId")
    }

    suspend fun searchAddons(
        gameId: Int,
        sectionId: Int = -1,
        categoryId: Int = -1,
        sort: AddonSortMethod = AddonSortMethod.FEATURED,
        sortDescending: Boolean = true,
        gameVersion: String? = null,
        index: Int = 0,
        pageSize: Int = 1000,
        searchFilter: String? = null
    ): List<Addon> {
        return http.get("api/v2/addon/search") {
            parameter("gameId", gameId)
            parameter("sectionId", sectionId)
            parameter("categoryId", categoryId)
            parameter("gameVersion", gameVersion)
            parameter("index", index)
            parameter("pageSize", pageSize)
            parameter("searchFilter", searchFilter)
            parameter("sort", sort)
            parameter("sortDescending", sortDescending)
        }
    }

    suspend fun getFeaturedAddons(
        gameId: Int,
        featuredCount: Int = 6,
        popularCount: Int = 14,
        updatedCount: Int = 14,
        excludedAddons: Collection<Int> = listOf()
    ): Map<FeaturedAddonType, List<Addon>> {
        return http.post("api/v2/addon/featured") {
            contentType(ContentType.Application.Json)
            body = FeaturedAddonsRequest(gameId, featuredCount, popularCount, updatedCount, excludedAddons)
        }
    }

    suspend fun getFeaturedAddons(
        gameId: Int,
        featuredCount: Int = 6,
        popularCount: Int = 14,
        updatedCount: Int = 14,
        vararg excludedAddons: Int
    ): Map<FeaturedAddonType, List<Addon>> = getFeaturedAddons(gameId, featuredCount, popularCount, updatedCount, excludedAddons.toList())

    suspend fun getCategory(categoryId: Int): Category {
        return http.get("api/v2/category/$categoryId")
    }

    suspend fun getCategory(slug: String): List<Category> {
        return http.get("api/v2/category") {
            parameter("slug", slug)
        }
    }

    suspend fun getCategorySection(sectionId: Int): List<Category> {
        return http.get("api/v2/category/section/$sectionId")
    }

    suspend fun getCategories(): List<Category> {
        return http.get("api/v2/category")
    }

    suspend fun getCategoryDatabaseTimestamp(): Date {
        return Json.parse(DateSerializer, http.get("api/v2/category/timestamp"))
    }

//    suspend fun getRepositoryMatchFromSlug(gameSlug: String, addonSlug: String): AddonRepositoryMatch {
//        return http.get("api/v2/addon/slug") {
//            parameter("gameSlug", gameSlug)
//            parameter("addonSlug", addonSlug)
//        }
//    }
    // doesn't work currently

    suspend fun getFingerprintMatches(fingerprints: Collection<Long>): FingerprintMatchResult {
        return http.post("api/v2/fingerprint") {
            contentType(ContentType.Application.Json)
            body = fingerprints
        }
    }

    suspend fun getFingerprintMatches(vararg fingerprints: Long): FingerprintMatchResult = getFingerprintMatches(fingerprints.toList())

    suspend fun getFuzzyFingerprintMatches(gameId: Int, fingerprints: List<FolderFingerprint>): List<FuzzyFingerprintMatch> {
        return http.post("api/v2/fingerprint/fuzzy") {
            contentType(ContentType.Application.Json)
            body = FuzzyMatchesRequest(gameId, fingerprints)
        }
    }

    suspend fun getModloader(key: String): ModloaderVersion {
        return http.get("api/v2/minecraft/modloader/$key")
    }

    suspend fun getModloaders(): List<ModloaderIndex> {
        return http.get("api/v2/minecraft/modloader")
    }

    suspend fun getModloaders(gameVersion: String): List<ModloaderIndex> {
        return http.get("api/v2/minecraft/modloader") {
            parameter("version", gameVersion)
        }
    }

    suspend fun getModloadersDatabaseTimestamp(): Date {
        return Json.parse(DateSerializer, http.get("api/v2/minecraft/modloader/timestamp"))
    }

    suspend fun getMinecraftVersions(): List<MinecraftVersion> {
        return http.get("api/v2/minecraft/version")
    }

    suspend fun getMinecraftVersion(gameVersion: String): MinecraftVersion {
        return http.get("api/v2/minecraft/version/$gameVersion")
    }

    suspend fun getMinecraftVersionsDatabaseTimestamp(): Date {
        return Json.parse(DateSerializer, http.get("api/v2/minecraft/version/timestamp"))
    }
}