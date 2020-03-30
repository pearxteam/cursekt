package net.pearx.cursekt.model.game

import kotlinx.serialization.*
import net.pearx.cursekt.util.EnumIntSerializer

@Serializable(with = GameFileType.Ser::class)
enum class GameFileType {
    GENERIC,
    GAME,
    LAUNCHER,
    PROFILER_LOCK_CHECK;

    internal object Ser : EnumIntSerializer<GameFileType>("GameFileType", values())
}