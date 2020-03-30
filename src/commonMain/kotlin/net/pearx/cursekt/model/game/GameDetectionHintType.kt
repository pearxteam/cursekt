
package net.pearx.cursekt.model.game

import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import net.pearx.cursekt.util.EnumIntSerializer

@Serializable(with = GameDetectionHintType.Ser::class)
enum class GameDetectionHintType {
    REGISTRY,
    FILE_PATH;

    internal object Ser : EnumIntSerializer<GameDetectionHintType>("GameDetectionHintType", values())
}