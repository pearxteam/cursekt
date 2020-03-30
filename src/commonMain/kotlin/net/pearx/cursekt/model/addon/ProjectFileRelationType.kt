package net.pearx.cursekt.model.addon

import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.EnumIntSerializer

@Serializable(with = ProjectFileRelationType.Ser::class)
enum class ProjectFileRelationType {
    EMBEDDED_LIBRARY,
    OPTIONAL_DEPENDENCY,
    REQUIRED_DEPENDENCY,
    TOOL,
    INCOMPATIBLE,
    INCLUDE;

    internal object Ser : EnumIntSerializer<ProjectFileRelationType>("ProjectFileRelationType", values())
}