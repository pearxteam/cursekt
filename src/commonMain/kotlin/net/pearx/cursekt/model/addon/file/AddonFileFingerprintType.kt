package net.pearx.cursekt.model.addon.file

import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.EnumIntSerializer
import net.pearx.cursekt.util.MODEL_PACKAGE

@Serializable(with = AddonFileFingerprintType.Ser::class)
enum class AddonFileFingerprintType {
    PACKAGE,
    MODULE,
    MAIN_MODULE,
    FILE,
    REFERRENCED_FILE;

    internal object Ser : EnumIntSerializer<AddonFileFingerprintType>("$MODEL_PACKAGE.addon.file.AddonFileFingerprintType", values())
}