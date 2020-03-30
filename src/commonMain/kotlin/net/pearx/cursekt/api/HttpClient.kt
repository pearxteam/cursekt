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
import io.ktor.client.request.header
import io.ktor.client.request.host
import io.ktor.client.request.url
import io.ktor.http.URLProtocol

internal val Http = HttpClient {
    install(JsonFeature) {
        serializer = KotlinxSerializer()
    }
    defaultRequest {
        url.protocol = URLProtocol.HTTPS
        url.host = "addons-ecs.forgesvc.net"
        header("accept", "*/*")
    }
}