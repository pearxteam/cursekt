/*
 * Copyright © 2020, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.cursekt.model.game

import net.pearx.cursekt.util.FlagSerializer
import net.pearx.cursekt.util.MODEL_PACKAGE

enum class SupportedClientConfiguration {
    DEBUG,
    BETA,
    RELEASE;

    internal object Ser : FlagSerializer<SupportedClientConfiguration>("$MODEL_PACKAGE.game.SupportedClientConfiguration", DEBUG to 0x1, BETA to 0x2, RELEASE to 0x4)
}