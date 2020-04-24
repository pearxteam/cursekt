package net.pearx.cursekt.model.minecraft.modloader

import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.EnumIntSerializer
import net.pearx.cursekt.util.MODEL_PACKAGE

@Serializable(with = ModloaderInstallMethod.Ser::class)
enum class ModloaderInstallMethod {
    ANY,
    FORGE,
    CAULDRON,
    LITE_LOADER;

    internal object Ser : EnumIntSerializer<ModloaderInstallMethod>("$MODEL_PACKAGE.game.ModloaderInstallMethod", values())
}