package net.pearx.cursekt.model.category

import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.Date
import net.pearx.cursekt.util.DateSerializer

@Serializable
data class Category(
    val id: Int,
    val name: String,
    val slug: String,
    val avatarUrl: String?,
    @Serializable(with = DateSerializer::class)
    val dateModified: Date,
    val parentGameCategoryId: Int?,
    val rootGameCategoryId: Int?,
    val gameId: Int
)