package net.pearx.cursekt.util

import kotlinx.serialization.Serializable

expect class Date

internal expect fun String.deserializeDate(): Date

internal expect fun Date.serializeDate(): String