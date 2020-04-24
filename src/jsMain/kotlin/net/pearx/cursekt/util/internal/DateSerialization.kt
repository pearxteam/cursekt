/*
 * Copyright © 2020, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.cursekt.util.internal

import net.pearx.cursekt.util.Date

internal actual fun String.deserializeDate(): Date = Date(this)

internal actual fun Date.serializeDate(): String = toISOString()