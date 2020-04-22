package net.pearx.cursekt.model.minecraft.modloader

import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.EnumIntSerializer

@Serializable(with = ModloaderInstallMethod.Ser::class)
enum class ModloaderInstallMethod {
    ANY,
    FORGE,
    CAULDRON,
    LITE_LOADER;

    internal object Ser : EnumIntSerializer<ModloaderInstallMethod>("ModLoaderInstallMethod", values())
}