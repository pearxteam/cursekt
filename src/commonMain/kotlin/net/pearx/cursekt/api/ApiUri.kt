package net.pearx.cursekt.api

internal const val CURSE_API_URI = ""
internal const val GAMES_URI = "$CURSE_API_URI/game"
internal const val GAME_URI = "$GAMES_URI/{gameId}"
internal const val ADDONS_URI = "$CURSE_API_URI/addon"
internal const val ADDON_URI = "$ADDONS_URI/{projectId}"
internal const val ADDON_DESCRIPTION_URI = "$ADDON_URI/description"
internal const val ADDON_FILES_URI = "$ADDON_URI/files"
internal const val ADDON_FILE_URI = "$ADDON_URI/file/{fileId}"
internal const val ADDON_FILE_CHANGELOG_URI = "$ADDON_FILE_URI/changelog"
internal const val ADDON_FILE_DOWNLOAD_URL_URI = "$ADDON_FILE_URI/download-url"