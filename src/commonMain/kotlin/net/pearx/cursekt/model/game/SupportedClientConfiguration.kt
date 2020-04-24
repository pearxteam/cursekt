package net.pearx.cursekt.model.game

import net.pearx.cursekt.util.FlagSerializer
import net.pearx.cursekt.util.MODEL_PACKAGE

enum class SupportedClientConfiguration {
    DEBUG,
    BETA,
    RELEASE;

    internal object Ser : FlagSerializer<SupportedClientConfiguration>("$MODEL_PACKAGE.game.SupportedClientConfiguration", DEBUG to 0x1, BETA to 0x2, RELEASE to 0x4)
}