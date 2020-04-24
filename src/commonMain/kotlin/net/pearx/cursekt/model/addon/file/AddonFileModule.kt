/*
 * Copyright © 2020, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.cursekt.model.addon.file

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AddonFileModule(
    @SerialName("foldername")
    val folderName: String,
    val fingerprint: Long,
    val type: AddonFileFingerprintType? = null
)