package net.pearx.cursekt.model.addon.request

import kotlinx.serialization.Serializable

@Serializable
data class FeaturedAddonsRequest(
    val gameId: Int,
    val featuredCount: Int,
    val popularCount: Int,
    val updatedCount: Int,
    val excludedAddons: Collection<Int>
)