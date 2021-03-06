/*
 * Copyright © 2020, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.cursekt.model.game

import kotlinx.serialization.Serializable

@Serializable
data class GameFile(
    val id: Int,
    val gameId: Int,
    val isRequired: Boolean,
    val fileName: String,
    val fileType: GameFileType,
    val platformType: GamePlatformType
)