/*
 * Copyright © 2020, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.cursekt.model.minecraft.modloader

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import net.pearx.cursekt.model.minecraft.MinecraftVersionStatus
import net.pearx.cursekt.model.minecraft.MinecraftVersionTypeStatus
import net.pearx.cursekt.util.Date
import net.pearx.cursekt.util.internal.DateSerializer

@Serializable
data class ModloaderVersion(
    val id: Int,
    val gameVersionId: Int,
    val minecraftGameVersionId: Int,
    val forgeVersion: String,
    val name: String,
    val type: ModloaderType,
    val downloadUrl: String,
    @SerialName("filename")
    val fileName: String,
    val installMethod: ModloaderInstallMethod,
    val latest: Boolean,
    val recommended: Boolean,
    val approved: Boolean,
    @Serializable(with = DateSerializer::class)
    val dateModified: Date,
    val mavenVersionString: String,
    val versionJson: String,
    val librariesInstallLocation: String,
    val minecraftVersion: String,
    val additionalFilesJson: String,
    val modLoaderGameVersionId: Int,
    val modLoaderGameVersionTypeId: Int,
    val modLoaderGameVersionStatus: MinecraftVersionStatus,
    val modLoaderGameVersionTypeStatus: MinecraftVersionTypeStatus,
    val mcGameVersionId: Int,
    val mcGameVersionTypeId: Int,
    val mcGameVersionStatus: MinecraftVersionStatus,
    val mcGameVersionTypeStatus: MinecraftVersionTypeStatus,
    val installProfileJson: String
)