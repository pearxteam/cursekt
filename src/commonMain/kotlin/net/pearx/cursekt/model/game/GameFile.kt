package net.pearx.cursekt.model.game

import kotlinx.serialization.Serializable

@Serializable
data class GameFile(
    val id: Int,
    val gameId: Int,
    val isRequired: Boolean,
    val fileName: String,
    val fileType: GameFileType,
    val platformType: GamePlatformType
)