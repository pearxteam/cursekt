package net.pearx.cursekt.util

import kotlinx.serialization.*

internal object DateSerializer : KSerializer<Date> {
    override val descriptor = PrimitiveDescriptor("Date", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): Date {
        return decoder.decodeString().deserializeDate()
    }

    override fun serialize(encoder: Encoder, value: Date) {
        encoder.encodeString(value.serializeDate())
    }
}