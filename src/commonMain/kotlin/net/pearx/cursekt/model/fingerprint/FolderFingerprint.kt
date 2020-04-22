package net.pearx.cursekt.model.fingerprint

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FolderFingerprint(
    @SerialName("foldername")
    val folderName: String,
    val fingerprints: List<Long>
)