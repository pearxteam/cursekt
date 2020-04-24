package net.pearx.cursekt.model.addon

import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.EnumIntSerializer
import net.pearx.cursekt.util.MODEL_PACKAGE

@Serializable(with = AddonAttachmentStatus.Ser::class)
enum class AddonAttachmentStatus {
    NORMAL,
    DELETED,
    UPLOADING,
    BANNED,
    PENDING_MODERATION;

    internal object Ser : EnumIntSerializer<AddonAttachmentStatus>("$MODEL_PACKAGE.addon.AttachmentStatus", values())
}