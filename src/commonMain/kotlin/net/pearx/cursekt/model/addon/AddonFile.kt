/*
 * Copyright © 2019-2020, PearX Team
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.pearx.cursekt.model.addon

import kotlinx.serialization.Serializable
import net.pearx.cursekt.model.PackageType
import net.pearx.cursekt.util.Date
import net.pearx.cursekt.util.DateSerializer

@Serializable
data class AddonFile(
    val id: Int,
    val displayName: String,
    val fileName: String,
    @Serializable(with = DateSerializer::class)
    val fileDate: Date,
    val fileLength: Long,
    val releaseType: ProjectFileReleaseType,
    val fileStatus: ProjectFileStatus,
    val downloadUrl: String,
    val isAlternate: Boolean,
    val alternateFileId: Int,
    val dependencies: List<AddonFileDependency>,
    val isAvailable: Boolean,
    val modules: List<AddonFileModule>,
    val packageFingerprint: Long,
    val gameVersion: List<String>,
    val sortableGameVersion: List<SortableGameVersion>? = null,
    val installMetadata: String?,
    val changelog: String? = null,
    val hasInstallScript: Boolean,
    val isCompatibleWithClient: Boolean? = null,
    val categorySectionPackageType: PackageType? = null,
    val restrictProjectFileAccess: ProjectRestrictProjectFileAccess? = null,
    val projectStatus: ProjectStatus? = null,
    val renderCacheId: Int? = null,
    val fileLegacyMappingId: Int? = null,
    val projectId: Int? = null,
    val parentProjectFileId: Int? = null,
    val parentFileLegacyMappingId: Int? = null,
    val fileTypeId: Int? = null,
    val exposeAsAlternative: Boolean? = null,
    val packageFingerprintId: Int? = null,
    @Serializable(with = DateSerializer::class)
    val gameVersionDateReleased: Date?,
    val gameVersionMappingId: Int? = null,
    val gameVersionId: Int? = null,
    val gameId: Int? = null,
    val isServerPack: Boolean = false,
    val serverPackFileId: Int?,
    val gameVersionFlavor: String?
)