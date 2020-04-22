package net.pearx.cursekt.model.fingerprint

import kotlinx.serialization.Serializable

@Serializable
data class FingerprintMatchResult(
    val isCacheBuilt: Boolean,
    val exactMatches: List<FingerprintMatch>,
    val exactFingerprints: List<Long>,
    val partialMatches: List<FingerprintMatch>,
    val partialMatchFingerprints: Map<String, List<Long>>,
    val installedFingerprints: List<Long>,
    val unmatchedFingerprints: List<Long>
)