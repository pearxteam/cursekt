package net.pearx.cursekt.model

import kotlinx.serialization.*
import net.pearx.cursekt.util.EnumIntSerializer

@Serializable(with = PackageType.Ser::class)
enum class PackageType {
    FOLDER,
    CTOC,
    SINGLE_FILE,
    CMOD2,
    MOD_PACK,
    MOD;

    internal object Ser : EnumIntSerializer<PackageType>("GamePackageType", values())
}