/*
 * Copyright © 2020, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.cursekt.util.internal

import kotlinx.serialization.*
import net.pearx.cursekt.util.Date
import net.pearx.cursekt.util.deserializeDate
import net.pearx.cursekt.util.serializeDate

internal object DateSerializer : KSerializer<Date> {
    override val descriptor = PrimitiveDescriptor("Date", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): Date {
        return decoder.decodeString().deserializeDate()
    }

    override fun serialize(encoder: Encoder, value: Date) {
        encoder.encodeString(value.serializeDate())
    }
}