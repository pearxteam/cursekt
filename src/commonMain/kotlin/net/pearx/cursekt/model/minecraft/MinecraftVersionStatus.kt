package net.pearx.cursekt.model.minecraft

import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.EnumIntSerializer

@Serializable(with = MinecraftVersionStatus.Ser::class)
enum class MinecraftVersionStatus {
    APPROVED,
    DELETED,
    NEW;

    internal object Ser : EnumIntSerializer<MinecraftVersionStatus>("GameVersionStatus", values())
}