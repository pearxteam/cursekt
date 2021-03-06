/*
 * Copyright © 2020, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.cursekt.util.internal

import kotlinx.serialization.*

internal open class EnumIntSerializer<T>(private val serialName: String, private val values: Array<T>, private val startFrom: Int = 1) : KSerializer<T> {
    override val descriptor: SerialDescriptor = PrimitiveDescriptor(serialName, PrimitiveKind.INT)

    override fun deserialize(decoder: Decoder): T {
        val value = decoder.decodeInt()
        return values[value - startFrom] ?: throw NoSuchElementException("Can't find $serialName with key $value")
    }

    override fun serialize(encoder: Encoder, value: T) {
        encoder.encodeInt(values.indexOf(value) + startFrom)
    }
}