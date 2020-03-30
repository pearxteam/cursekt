package net.pearx.cursekt.model.game

import kotlinx.serialization.Serializable
import net.pearx.cursekt.model.CategorySection
import net.pearx.cursekt.model.SupportedClientConfiguration

@Serializable
data class Game(
    val id: Int,
    val name: String,
    val slug: String,
    val dateModified: String, // todo datetime
    val gameFiles: List<GameFile>,
    val gameDetectionHints: List<GameDetectionHint>,
    val fileParsingRules: List<GameFileParsingRule>, // always empty, so can't say if it's a String
    val categorySections: List<CategorySection>,
    val maxFreeStorage: Long,
    val maxPremiumStorage: Long,
    val maxFileSize: Long,
    val addonSettingsFolderFilter: String?,
    val addonSettingsStartingFolder: String?,
    val addonSettingsFileFilter: String?,
    val addonSettingsFileRemovalFilter: String?,
    val supportsAddons: Boolean,
    val supportsPartnerAddons: Boolean,
    val supportedClientConfiguration: SupportedClientConfiguration,
    val supportsNotifications: Boolean,
    val profilerAddonId: Int,
    val twitchGameId: Int,
    val clientGameSettingsId: Int
)