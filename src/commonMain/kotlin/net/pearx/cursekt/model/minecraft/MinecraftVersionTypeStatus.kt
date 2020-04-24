package net.pearx.cursekt.model.minecraft

import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.EnumIntSerializer
import net.pearx.cursekt.util.MODEL_PACKAGE

@Serializable(with = MinecraftVersionTypeStatus.Ser::class)
enum class MinecraftVersionTypeStatus {
    NORMAL,
    DELETED;

    internal object Ser : EnumIntSerializer<MinecraftVersionTypeStatus>("$MODEL_PACKAGE.game.MinecraftVersionTypeStatus", values())
}