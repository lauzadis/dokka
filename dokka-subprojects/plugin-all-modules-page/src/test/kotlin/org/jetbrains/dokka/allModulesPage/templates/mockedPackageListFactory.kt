/*
 * Copyright 2014-2023 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
 */

package org.jetbrains.dokka.allModulesPage.templates

import org.jetbrains.dokka.base.resolvers.shared.PackageList
import org.jetbrains.dokka.base.resolvers.shared.RecognizedLinkFormat

internal fun mockedPackageListForPackages(format: RecognizedLinkFormat, vararg packages: String): String =
    """
       ${PackageList.DOKKA_PARAM_PREFIX}.format:${format.formatName}
       ${PackageList.DOKKA_PARAM_PREFIX}.linkExtension:${format.linkExtension}
       
       ${packages.sorted().joinToString(separator = "\n", postfix = "\n") { it }}
    """.trimIndent()
