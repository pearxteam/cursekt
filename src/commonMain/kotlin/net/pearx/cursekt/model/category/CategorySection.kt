package net.pearx.cursekt.model.category

import kotlinx.serialization.Serializable
import net.pearx.cursekt.model.addon.AddonPackageType

@Serializable
data class CategorySection(
    val extraIncludePattern: String?,
    val gameCategoryId: Int,
    val gameId: Int,
    val id: Int,
    val initialInclusionPattern: String,
    val name: String,
    val packageType: AddonPackageType,
    val path: String
)