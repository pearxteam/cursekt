package net.pearx.cursekt.model.addon.file

import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.EnumIntSerializer

@Serializable(with = AddonFileRelationType.Ser::class)
enum class AddonFileRelationType {
    EMBEDDED_LIBRARY,
    OPTIONAL_DEPENDENCY,
    REQUIRED_DEPENDENCY,
    TOOL,
    INCOMPATIBLE,
    INCLUDE;

    internal object Ser : EnumIntSerializer<AddonFileRelationType>("AddonFileRelationType", values())
}