package net.pearx.cursekt.util

import java.time.Instant
import java.time.OffsetDateTime
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder

actual typealias Date = OffsetDateTime

private val formatter = DateTimeFormatter.ISO_DATE_TIME

internal actual fun String.deserializeDate(): Date = OffsetDateTime.parse(this)

internal actual fun Date.serializeDate(): String = toString()