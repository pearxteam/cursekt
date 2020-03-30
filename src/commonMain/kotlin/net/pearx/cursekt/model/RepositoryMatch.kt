package net.pearx.cursekt.model

import kotlinx.serialization.Serializable
import net.pearx.cursekt.model.addon.AddonFile

@Serializable
data class RepositoryMatch(
    val id: Int,
    val latestFiles: List<AddonFile>
)