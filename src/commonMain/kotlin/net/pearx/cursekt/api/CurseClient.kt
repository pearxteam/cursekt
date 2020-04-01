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
import net.pearx.cursekt.model.RepositoryMatch
import net.pearx.cursekt.model.addon.Addon
import net.pearx.cursekt.model.addon.AddonFile
import net.pearx.cursekt.model.addon.AddonSortMethod
import net.pearx.cursekt.model.addon.FeaturedAddonType
import net.pearx.cursekt.model.game.Game
import net.pearx.cursekt.model.request.FeaturedAddonsRequest

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

    suspend fun getGames(supportsAddons: Boolean? = null): List<Game> {
        return http.get("api/v2/game") {
            parameter("supportsAddons", supportsAddons.toString())
        }
    }

    suspend fun getGame(gameId: Int): Game {
        return http.get("api/v2/game/$gameId")
    }

    suspend fun getGameDatabaseTimestamp(): String { // todo datetime
        return http.get("api/v2/game/timestamp")
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
        return http.get("api/v2/addon/$projectId/")
    }

    suspend fun getAddonFile(projectId: Int, fileId: Int): AddonFile {
        return http.get("api/v2/addon/$projectId/file/$fileId")
    }

    suspend fun getRepositoryMatchFromSlug(gameSlug: String, addonSlug: String): RepositoryMatch {
        return http.get("api/v2/addon/slug") {
            parameter("gameSlug", gameSlug)
            parameter("addonSlug", addonSlug)
        }
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

//suspend fun getFingerprintMatches(fingerprints: Collection<Long>): List<Add> {
//    Http.post<>()
//}

}