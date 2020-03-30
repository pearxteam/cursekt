package net.pearx.cursekt.model.addon

import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.EnumIntSerializer

@Serializable(with = ProjectRestrictProjectFileAccess.Ser::class)
enum class ProjectRestrictProjectFileAccess {
    NONE,
    ALPHA,
    ALPHA_AND_BETA;

    internal object Ser : EnumIntSerializer<ProjectRestrictProjectFileAccess>("ProjectRestrictProjectFileAccess", values())
}