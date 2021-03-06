/*
 * Copyright © 2020, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.cursekt.model.addon

import kotlinx.serialization.Serializable

@Serializable
data class AddonAttachment(
    val id: Int,
    val projectId: Int,
    val description: String,
    val isDefault: Boolean,
    val thumbnailUrl: String,
    val title: String,
    val url: String,
    val status: AddonAttachmentStatus
)