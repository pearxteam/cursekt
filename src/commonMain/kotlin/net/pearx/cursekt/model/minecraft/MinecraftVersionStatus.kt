package net.pearx.cursekt.model.minecraft

import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.EnumIntSerializer
import net.pearx.cursekt.util.MODEL_PACKAGE

@Serializable(with = MinecraftVersionStatus.Ser::class)
enum class MinecraftVersionStatus {
    APPROVED,
    DELETED,
    NEW;

    internal object Ser : EnumIntSerializer<MinecraftVersionStatus>("$MODEL_PACKAGE.game.MinecraftVersionStatus", values())
}