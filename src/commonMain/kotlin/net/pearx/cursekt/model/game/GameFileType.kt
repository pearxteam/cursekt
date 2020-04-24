/*
 * Copyright © 2020, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.cursekt.model.game

import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.internal.EnumIntSerializer
import net.pearx.cursekt.util.internal.MODEL_PACKAGE

@Serializable(with = GameFileType.Ser::class)
enum class GameFileType {
    GENERIC,
    GAME,
    LAUNCHER,
    PROFILER_LOCK_CHECK;

    internal object Ser : EnumIntSerializer<GameFileType>("$MODEL_PACKAGE.game.GameFileType", values())
}