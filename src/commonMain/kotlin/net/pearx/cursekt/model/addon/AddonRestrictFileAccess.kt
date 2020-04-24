/*
 * Copyright © 2020, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.cursekt.model.addon

import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.EnumIntSerializer
import net.pearx.cursekt.util.MODEL_PACKAGE

@Serializable(with = AddonRestrictFileAccess.Ser::class)
enum class AddonRestrictFileAccess {
    NONE,
    ALPHA,
    ALPHA_AND_BETA;

    internal object Ser : EnumIntSerializer<AddonRestrictFileAccess>("$MODEL_PACKAGE.addon.AddonRestrictFileAccess", values())
}