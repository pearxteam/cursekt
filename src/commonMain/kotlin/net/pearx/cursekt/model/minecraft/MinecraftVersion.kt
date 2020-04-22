package net.pearx.cursekt.model.minecraft

import kotlinx.serialization.Serializable
import net.pearx.cursekt.util.Date
import net.pearx.cursekt.util.DateSerializer

@Serializable
data class MinecraftVersion(
    val id: Int,
    val gameVersionId: Int,
    val versionString: String,
    val jarDownloadUrl: String,
    val jsonDownloadUrl: String,
    val approved: Boolean,
    @Serializable(with = DateSerializer::class)
    val dateModified: Date,
    val gameVersionTypeId: Int,
    val gameVersionStatus: MinecraftVersionStatus,
    val gameVersionTypeStatus: MinecraftVersionTypeStatus
)