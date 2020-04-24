package net.pearx.cursekt.util

import kotlinx.serialization.*

internal open class FlagSerializer<T : Enum<T>>(serialName: String, private val map: Map<T, Int>) : KSerializer<Set<T>> {
    constructor(serialName: String, vararg pairs: Pair<T, Int>) : this(serialName, mapOf(*pairs))

    override val descriptor: SerialDescriptor = PrimitiveDescriptor(serialName, PrimitiveKind.INT)

    override fun serialize(encoder: Encoder, value: Set<T>) {
        var bits = 0
        for(flag in value) {
            bits = bits or (map[flag] ?: error(""))
        }
        encoder.encodeInt(bits)
    }

    override fun deserialize(decoder: Decoder): Set<T> {
        val set = mutableSetOf<T>()
        val bits = decoder.decodeInt()
        for((flag, shift) in map) {
            if(bits and shift == shift)
                set += flag
        }
        return set
    }
}