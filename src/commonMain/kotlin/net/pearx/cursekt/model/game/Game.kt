package net.pearx.cursekt.model.game

import kotlinx.serialization.Serializable
import net.pearx.cursekt.model.category.CategorySection
import net.pearx.cursekt.util.Date
import net.pearx.cursekt.util.DateSerializer

@Serializable
data class Game(
    val id: Int,
    val name: String,
    val slug: String,
    @Serializable(with = DateSerializer::class)
    val dateModified: Date,
    val gameFiles: List<GameFile>,
    val gameDetectionHints: List<GameDetectionHint>,
    val fileParsingRules: List<GameFileParsingRule>,
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
    @Serializable(with = SupportedClientConfiguration.Ser::class)
    val supportedClientConfiguration: Set<SupportedClientConfiguration>,
    val supportsNotifications: Boolean,
    val profilerAddonId: Int,
    val twitchGameId: Int,
    val clientGameSettingsId: Int
)