/*
 * Copyright © 2020, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.cursekt.model.minecraft

import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.EnumIntSerializer
import net.pearx.cursekt.util.MODEL_PACKAGE

@Serializable(with = MinecraftVersionStatus.Ser::class)
enum class MinecraftVersionStatus {
    APPROVED,
    DELETED,
    NEW;

    internal object Ser : EnumIntSerializer<MinecraftVersionStatus>("$MODEL_PACKAGE.game.MinecraftVersionStatus", values())
}