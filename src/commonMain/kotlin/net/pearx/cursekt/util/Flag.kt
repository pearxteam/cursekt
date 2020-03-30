package net.pearx.cursekt.util

import kotlinx.serialization.*

internal fun flag(value: Boolean, flag: Int) = 0.flag(value, flag)

internal fun Int.flag(value: Boolean, flag: Int): Int = if (value) this or flag else this

internal fun Int.flag(shift: Int): Boolean = this and shift == shift

internal abstract class FlagSerializer<T>(serialName: String) : KSerializer<T> {
    override val descriptor: SerialDescriptor = PrimitiveDescriptor(serialName, PrimitiveKind.INT)

    protected abstract fun T.toFlags(): Int
    protected abstract fun Int.fromFlags(): T

    override fun serialize(encoder: Encoder, value: T) {
        encoder.encodeInt(value.toFlags())
    }

    override fun deserialize(decoder: Decoder): T {
        return decoder.decodeInt().fromFlags()
    }
}