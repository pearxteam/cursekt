
package net.pearx.cursekt.model.game

import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.EnumIntSerializer
import net.pearx.cursekt.util.MODEL_PACKAGE

@Serializable(with = GameDetectionHintType.Ser::class)
enum class GameDetectionHintType {
    REGISTRY,
    FILE_PATH;

    internal object Ser : EnumIntSerializer<GameDetectionHintType>("$MODEL_PACKAGE.game.GameDetectionHintType", values())
}