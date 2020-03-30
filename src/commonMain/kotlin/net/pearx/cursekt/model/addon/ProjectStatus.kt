package net.pearx.cursekt.model.addon

import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.EnumIntSerializer

@Serializable(with = ProjectStatus.Ser::class)
enum class ProjectStatus {
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

    internal object Ser : EnumIntSerializer<ProjectStatus>("ProjectStatus", values())
}