package net.pearx.cursekt.model.game

import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.FlagSerializer
import net.pearx.cursekt.util.flag

@Serializable(with = GameDetectionHintOptions.Ser::class)
data class GameDetectionHintOptions(val none: Boolean, val includeSubFolders: Boolean, val folderOnly: Boolean) {
    internal object Ser : FlagSerializer<GameDetectionHintOptions>("GameDetectionHintOption") {
        private const val NONE = 0x1
        private const val INCLUDE_SUB_FOLDERS = 0x2
        private const val FOLDER_ONLY = 0x4

        override fun GameDetectionHintOptions.toFlags() = flag(none, NONE).flag(includeSubFolders, INCLUDE_SUB_FOLDERS).flag(folderOnly, FOLDER_ONLY)
        override fun Int.fromFlags() = GameDetectionHintOptions(flag(NONE), flag(INCLUDE_SUB_FOLDERS), flag(FOLDER_ONLY))
    }
}