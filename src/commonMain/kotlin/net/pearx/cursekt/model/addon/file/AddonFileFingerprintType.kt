/*
 * Copyright © 2020, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.cursekt.model.addon.file

import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.internal.EnumIntSerializer
import net.pearx.cursekt.util.internal.MODEL_PACKAGE

@Serializable(with = AddonFileFingerprintType.Ser::class)
enum class AddonFileFingerprintType {
    PACKAGE,
    MODULE,
    MAIN_MODULE,
    FILE,
    REFERRENCED_FILE;

    internal object Ser : EnumIntSerializer<AddonFileFingerprintType>("$MODEL_PACKAGE.addon.file.AddonFileFingerprintType", values())
}