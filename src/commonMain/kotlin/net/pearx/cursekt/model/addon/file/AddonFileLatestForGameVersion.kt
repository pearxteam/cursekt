/*
 * Copyright © 2020, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.cursekt.model.addon.file

import kotlinx.serialization.Serializable

@Serializable
data class AddonFileLatestForGameVersion(
    val gameVersion: String,
    val projectFileId: Int,
    val projectFileName: String,
    val fileType: AddonFileReleaseType,
    val gameVersionFlavor: String?
)