package net.pearx.cursekt.model.game

import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.FlagSerializer
import net.pearx.cursekt.util.flag

@Serializable(with = SupportedClientConfiguration.Ser::class)
data class SupportedClientConfiguration(val debug: Boolean, val beta: Boolean, val release: Boolean) {
    internal object Ser : FlagSerializer<SupportedClientConfiguration>("SupportedClientConfiguration") {
        private const val DEBUG = 0x1
        private const val BETA = 0x2
        private const val RELEASE = 0x4

        override fun SupportedClientConfiguration.toFlags() = flag(debug, DEBUG).flag(beta, BETA).flag(release, RELEASE)
        override fun Int.fromFlags() = SupportedClientConfiguration(flag(DEBUG), flag(BETA), flag(RELEASE))
    }
}