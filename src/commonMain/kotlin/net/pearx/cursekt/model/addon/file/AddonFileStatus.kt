package net.pearx.cursekt.model.addon.file

import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.EnumIntSerializer
import net.pearx.cursekt.util.MODEL_PACKAGE

@Serializable(with = AddonFileStatus.Ser::class)
enum class AddonFileStatus {
    PROCESSING,
    CHANGES_REQUIRED,
    UNDER_REVIEW,
    APPROVED,
    REJECTED,
    MALWARE_DETECTED,
    DELETED,
    ARCHIVED,
    TESTING,
    RELEASED,
    READY_FOR_REVIEW,
    DEPRECATED,
    BAKING,
    AWAITING_FOR_PUBLISHING,
    FAILED_PUBLISHING;

    internal object Ser : EnumIntSerializer<AddonFileStatus>("$MODEL_PACKAGE.addon.file.AddonFileStatus", values())
}