package net.pearx.cursekt.model.minecraft.modloader

import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.EnumIntSerializer

@Serializable(with = ModloaderType.Ser::class)
enum class ModloaderType {
    ANY,
    FORGE,
    CAULDRON,
    LITE_LOADER;

    internal object Ser : EnumIntSerializer<ModloaderType>("ModLoaderType", values(), 0)
}