package net.pearx.cursekt.util

expect class Date

internal expect fun String.deserializeDate(): Date

internal expect fun Date.serializeDate(): String