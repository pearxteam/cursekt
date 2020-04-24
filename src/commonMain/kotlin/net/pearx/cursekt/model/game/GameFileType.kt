package net.pearx.cursekt.model.game

import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.EnumIntSerializer
import net.pearx.cursekt.util.MODEL_PACKAGE

@Serializable(with = GameFileType.Ser::class)
enum class GameFileType {
    GENERIC,
    GAME,
    LAUNCHER,
    PROFILER_LOCK_CHECK;

    internal object Ser : EnumIntSerializer<GameFileType>("$MODEL_PACKAGE.game.GameFileType", values())
}