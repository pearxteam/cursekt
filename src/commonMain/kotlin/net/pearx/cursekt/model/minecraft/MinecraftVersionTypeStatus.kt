package net.pearx.cursekt.model.minecraft

import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.EnumIntSerializer

@Serializable(with = MinecraftVersionTypeStatus.Ser::class)
enum class MinecraftVersionTypeStatus {
    NORMAL,
    DELETED;

    internal object Ser : EnumIntSerializer<MinecraftVersionTypeStatus>("GameVersionTypeStatus", values())
}