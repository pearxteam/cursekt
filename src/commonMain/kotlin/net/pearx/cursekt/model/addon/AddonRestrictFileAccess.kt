package net.pearx.cursekt.model.addon

import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.EnumIntSerializer

@Serializable(with = AddonRestrictFileAccess.Ser::class)
enum class AddonRestrictFileAccess {
    NONE,
    ALPHA,
    ALPHA_AND_BETA;

    internal object Ser : EnumIntSerializer<AddonRestrictFileAccess>("AddonRestrictFileAccess", values())
}