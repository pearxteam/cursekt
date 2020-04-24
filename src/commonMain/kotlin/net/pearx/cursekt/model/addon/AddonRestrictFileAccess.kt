package net.pearx.cursekt.model.addon

import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.EnumIntSerializer
import net.pearx.cursekt.util.MODEL_PACKAGE

@Serializable(with = AddonRestrictFileAccess.Ser::class)
enum class AddonRestrictFileAccess {
    NONE,
    ALPHA,
    ALPHA_AND_BETA;

    internal object Ser : EnumIntSerializer<AddonRestrictFileAccess>("$MODEL_PACKAGE.addon.AddonRestrictFileAccess", values())
}