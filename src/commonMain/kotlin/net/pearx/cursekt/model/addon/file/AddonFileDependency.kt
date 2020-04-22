package net.pearx.cursekt.model.addon.file

import kotlinx.serialization.Serializable

@Serializable
data class AddonFileDependency(
    val id: Int? = null,
    val addonId: Int,
    val type: AddonFileRelationType,
    val fileId: Int? = null
)