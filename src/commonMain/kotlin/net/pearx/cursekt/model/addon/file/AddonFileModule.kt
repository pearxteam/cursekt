package net.pearx.cursekt.model.addon.file

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AddonFileModule(
    @SerialName("foldername")
    val folderName: String,
    val fingerprint: Long,
    val type: AddonFileFingerprintType? = null
)