package net.pearx.cursekt.model.addon.file

import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.EnumIntSerializer
import net.pearx.cursekt.util.MODEL_PACKAGE

@Serializable(with = AddonFileReleaseType.Ser::class)
enum class AddonFileReleaseType {
    RELEASE,
    BETA,
    ALPHA;

    internal object Ser : EnumIntSerializer<AddonFileReleaseType>("$MODEL_PACKAGE.addon.file.AddonFileReleaseType", values())
}