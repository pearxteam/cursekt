package net.pearx.cursekt.model.game

import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.EnumIntSerializer
import net.pearx.cursekt.util.MODEL_PACKAGE

@Serializable(with = GamePlatformType.Ser::class)
enum class GamePlatformType {
    GENERIC,
    WINDOWS_32,
    WINDOWS_64,
    WINDOWS,
    OSX;

    internal object Ser : EnumIntSerializer<GamePlatformType>("$MODEL_PACKAGE.game.GamePlatformType", values())
}