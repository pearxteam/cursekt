package net.pearx.cursekt.model.addon.file

import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.EnumIntSerializer

@Serializable(with = AddonFileReleaseType.Ser::class)
enum class AddonFileReleaseType {
    RELEASE,
    BETA,
    ALPHA;

    internal object Ser : EnumIntSerializer<AddonFileReleaseType>("AddonFileReleaseType", values())
}