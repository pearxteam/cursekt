/*
 * Copyright © 2020, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.cursekt.model.fingerprint.request

import kotlinx.serialization.Serializable
import net.pearx.cursekt.model.fingerprint.FolderFingerprint

@Serializable
data class FuzzyMatchesRequest(
    val gameId: Int,
    val fingerprints: List<FolderFingerprint>
)