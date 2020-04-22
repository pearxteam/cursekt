package net.pearx.cursekt.util

import java.time.OffsetDateTime

actual typealias Date = OffsetDateTime

internal actual fun String.deserializeDate(): Date = OffsetDateTime.parse(this)

internal actual fun Date.serializeDate(): String = toString()