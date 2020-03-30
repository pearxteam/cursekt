package net.pearx.cursekt.util

import kotlinx.serialization.*

open class EnumIntSerializer<T>(val serialName: String, val values: Array<T>, val startFrom: Int = 1) : KSerializer<T> {
    override val descriptor: SerialDescriptor = PrimitiveDescriptor(serialName, PrimitiveKind.INT)

    override fun deserialize(decoder: Decoder): T {
        val value = decoder.decodeInt()
        return values[value - startFrom] ?: throw NoSuchElementException("Can't find $serialName with key $value")
    }

    override fun serialize(encoder: Encoder, value: T) {
        encoder.encodeInt(values.indexOf(value) + startFrom)
    }
}