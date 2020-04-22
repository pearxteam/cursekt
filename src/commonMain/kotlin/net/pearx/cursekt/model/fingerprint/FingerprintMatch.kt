package net.pearx.cursekt.model.fingerprint

import kotlinx.serialization.Serializable
import net.pearx.cursekt.model.addon.file.AddonFile

@Serializable
data class FingerprintMatch(
    val id: Int,
    val file: AddonFile,
    val latestFiles: List<AddonFile>
)