package net.pearx.cursekt.model.addon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.EnumIntSerializer

@Serializable
enum class FeaturedAddonType {
    @SerialName("Featured")
    FEATURED,
    @SerialName("Popular")
    POPULAR,
    @SerialName("RecentlyUpdated")
    RECENTLY_UPDATED;
}