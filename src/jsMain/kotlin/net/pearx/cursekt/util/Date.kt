package net.pearx.cursekt.util


actual typealias Date = kotlin.js.Date

internal actual fun String.deserializeDate(): Date = Date(this)

internal actual fun Date.serializeDate(): String = toISOString()