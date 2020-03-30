package net.pearx.cursekt.model.addon

import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.EnumIntSerializer

@Serializable(with = ProjectFileFingerprintType.Ser::class)
enum class ProjectFileFingerprintType {
    PACKAGE,
    MODULE,
    MAIN_MODULE,
    FILE,
    REFERRENCED_FILE;

    internal object Ser : EnumIntSerializer<ProjectFileFingerprintType>("ProjectFileFingerprintType", values())
}