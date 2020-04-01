package net.pearx.cursekt.model.addon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class FeaturedAddonType {
    @SerialName("Featured")
    FEATURED,
    @SerialName("Popular")
    POPULAR,
    @SerialName("RecentlyUpdated")
    RECENTLY_UPDATED;
}