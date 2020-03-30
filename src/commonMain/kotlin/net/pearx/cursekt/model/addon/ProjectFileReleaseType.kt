package net.pearx.cursekt.model.addon

import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.EnumIntSerializer

@Serializable(with = ProjectFileReleaseType.Ser::class)
enum class ProjectFileReleaseType {
    RELEASE,
    BETA,
    ALPHA;

    internal object Ser : EnumIntSerializer<ProjectFileReleaseType>("ProjectFileReleaseType", values())
}