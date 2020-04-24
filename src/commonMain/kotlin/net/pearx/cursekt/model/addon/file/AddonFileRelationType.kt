package net.pearx.cursekt.model.addon.file

import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.EnumIntSerializer
import net.pearx.cursekt.util.MODEL_PACKAGE

@Serializable(with = AddonFileRelationType.Ser::class)
enum class AddonFileRelationType {
    EMBEDDED_LIBRARY,
    OPTIONAL_DEPENDENCY,
    REQUIRED_DEPENDENCY,
    TOOL,
    INCOMPATIBLE,
    INCLUDE;

    internal object Ser : EnumIntSerializer<AddonFileRelationType>("$MODEL_PACKAGE.addon.file.AddonFileRelationType", values())
}