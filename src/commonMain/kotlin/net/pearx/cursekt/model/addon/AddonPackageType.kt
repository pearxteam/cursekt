package net.pearx.cursekt.model.addon

import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.EnumIntSerializer
import net.pearx.cursekt.util.MODEL_PACKAGE

@Serializable(with = AddonPackageType.Ser::class)
enum class AddonPackageType {
    FOLDER,
    CTOC,
    SINGLE_FILE,
    CMOD2,
    MOD_PACK,
    MOD;

    internal object Ser : EnumIntSerializer<AddonPackageType>("$MODEL_PACKAGE.addon.AddonPackageType", values())
}