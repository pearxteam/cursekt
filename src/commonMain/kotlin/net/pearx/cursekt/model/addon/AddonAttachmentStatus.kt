/*
 * Copyright © 2020, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.cursekt.model.addon

import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.internal.EnumIntSerializer
import net.pearx.cursekt.util.internal.MODEL_PACKAGE

@Serializable(with = AddonAttachmentStatus.Ser::class)
enum class AddonAttachmentStatus {
    NORMAL,
    DELETED,
    UPLOADING,
    BANNED,
    PENDING_MODERATION;

    internal object Ser : EnumIntSerializer<AddonAttachmentStatus>("$MODEL_PACKAGE.addon.AttachmentStatus", values())
}