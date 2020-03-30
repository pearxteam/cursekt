package net.pearx.cursekt.model.addon

import kotlinx.serialization.Serializable

@Serializable
data class AddonFileDependency(
    val id: Int,
    val addonId: Int,
    val type: ProjectFileRelationType,
    val fileId: Int
)