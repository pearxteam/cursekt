package net.pearx.cursekt.model.addon

import kotlinx.serialization.Serializable
import net.pearx.cursekt.model.addon.file.AddonFile

@Serializable
data class AddonRepositoryMatch(
    val id: Int,
    val latestFiles: List<AddonFile>
)