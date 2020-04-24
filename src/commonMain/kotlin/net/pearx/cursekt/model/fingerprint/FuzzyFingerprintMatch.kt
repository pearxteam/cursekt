/*
 * Copyright © 2020, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.cursekt.model.fingerprint

import kotlinx.serialization.Serializable
import net.pearx.cursekt.model.addon.file.AddonFile

@Serializable
data class FuzzyFingerprintMatch(
    val id: Int,
    val file: AddonFile,
    val latestFiles: List<AddonFile>,
    val fingerprints: List<Long>
)