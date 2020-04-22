package net.pearx.cursekt.model.addon.file

import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.EnumIntSerializer

@Serializable(with = AddonFileFingerprintType.Ser::class)
enum class AddonFileFingerprintType {
    PACKAGE,
    MODULE,
    MAIN_MODULE,
    FILE,
    REFERRENCED_FILE;

    internal object Ser : EnumIntSerializer<AddonFileFingerprintType>("AddonFileFingerprintType", values())
}