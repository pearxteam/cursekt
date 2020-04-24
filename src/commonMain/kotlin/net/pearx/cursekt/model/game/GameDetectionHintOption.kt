package net.pearx.cursekt.model.game

import net.pearx.cursekt.util.FlagSerializer
import net.pearx.cursekt.util.MODEL_PACKAGE

enum class GameDetectionHintOption {
    NONE,
    INCLUDE_SUB_FOLDERS,
    FOLDER_ONLY;

    internal object Ser : FlagSerializer<GameDetectionHintOption>("$MODEL_PACKAGE.game.GameDetectionHintOption", NONE to 0x1, INCLUDE_SUB_FOLDERS to 0x2, FOLDER_ONLY to 0x4)
}