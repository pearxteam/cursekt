package net.pearx.cursekt.model.game

import kotlinx.serialization.Serializable

@Serializable
data class GameFileParsingRule(
    val commentStripPattern: String,
    val fileExtension: String,
    val inclusionPattern: String,
    val gameId: Int,
    val id: Int
)