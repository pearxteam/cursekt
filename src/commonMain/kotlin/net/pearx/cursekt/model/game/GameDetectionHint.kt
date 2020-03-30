package net.pearx.cursekt.model.game

import kotlinx.serialization.Serializable

@Serializable
data class GameDetectionHint(
    val id: Int,
    val hintType: GameDetectionHintType,
    val hintPath: String,
    val hintKey: String?,
    val hintOptions: GameDetectionHintOptions,
    val gameId: Int
)