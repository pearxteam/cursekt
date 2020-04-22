package net.pearx.cursekt.model.fingerprint.request

import kotlinx.serialization.Serializable
import net.pearx.cursekt.model.fingerprint.FolderFingerprint

@Serializable
data class FuzzyMatchesRequest(
    val gameId: Int,
    val fingerprints: List<FolderFingerprint>
)