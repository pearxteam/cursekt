/*
 * Copyright © 2020, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.cursekt.model.minecraft

import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.Date
import net.pearx.cursekt.util.DateSerializer

@Serializable
data class MinecraftVersion(
    val id: Int,
    val gameVersionId: Int,
    val versionString: String,
    val jarDownloadUrl: String,
    val jsonDownloadUrl: String,
    val approved: Boolean,
    @Serializable(with = DateSerializer::class)
    val dateModified: Date,
    val gameVersionTypeId: Int,
    val gameVersionStatus: MinecraftVersionStatus,
    val gameVersionTypeStatus: MinecraftVersionTypeStatus
)