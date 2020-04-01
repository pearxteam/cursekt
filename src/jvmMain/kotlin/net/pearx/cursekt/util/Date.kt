package net.pearx.cursekt.util

import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

actual typealias Date = OffsetDateTime

private val formatter = DateTimeFormatter.ISO_DATE_TIME

internal actual fun String.deserializeDate(): Date = OffsetDateTime.parse(this)

internal actual fun Date.serializeDate(): String = toString()