package net.pearx.cursekt.util

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