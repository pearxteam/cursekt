package net.pearx.cursekt.model.addon

import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.EnumIntSerializer

@Serializable(with = AttachmentStatus.Ser::class)
enum class AttachmentStatus {
    NORMAL,
    DELETED,
    UPLOADING,
    BANNED,
    PENDING_MODERATION;

    internal object Ser : EnumIntSerializer<AttachmentStatus>("AttachmentStatus", values())
}