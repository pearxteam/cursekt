package net.pearx.cursekt.model.addon

import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.EnumIntSerializer

@Serializable(with = AddonStatus.Ser::class)
enum class AddonStatus {
    NEW,
    CHANGES_REQUIRED,
    UNDER_SOFT_REVIEW,
    APPROVED,
    REJECTED,
    CHANGES_MADE,
    INACTIVE,
    ABANDONED,
    DELETED,
    UNDER_REVIEW;

    internal object Ser : EnumIntSerializer<AddonStatus>("ProjectStatus", values())
}