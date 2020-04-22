package net.pearx.cursekt.model.minecraft.modloader

import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.Date
import net.pearx.cursekt.util.DateSerializer

@Serializable
data class ModloaderIndex(
    val name: String,
    val gameVersion: String,
    val latest: Boolean,
    val recommended: Boolean,
    @Serializable(with = DateSerializer::class)
    val dateModified: Date
)