package net.pearx.cursekt.model

import kotlinx.serialization.Serializable

@Serializable
data class CategorySection(
    val extraIncludePattern: String?,
    val gameCategoryId: Int,
    val gameId: Int,
    val id: Int,
    val initialInclusionPattern: String,
    val name: String,
    val packageType: PackageType,
    val path: String
)