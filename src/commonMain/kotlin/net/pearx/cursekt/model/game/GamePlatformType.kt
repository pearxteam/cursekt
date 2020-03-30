package net.pearx.cursekt.model.game

import kotlinx.serialization.*
import net.pearx.cursekt.util.EnumIntSerializer

@Serializable(with = GamePlatformType.Ser::class)
enum class GamePlatformType {
    GENERIC,
    WINDOWS_32,
    WINDOWS_64,
    WINDOWS,
    OSX;

    internal object Ser : EnumIntSerializer<GamePlatformType>("GamePlatformType", values())
}