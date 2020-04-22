package net.pearx.cursekt.model.addon

import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.EnumIntSerializer

@Serializable(with = AddonPackageType.Ser::class)
enum class AddonPackageType {
    FOLDER,
    CTOC,
    SINGLE_FILE,
    CMOD2,
    MOD_PACK,
    MOD;

    internal object Ser : EnumIntSerializer<AddonPackageType>("GamePackageType", values())
}