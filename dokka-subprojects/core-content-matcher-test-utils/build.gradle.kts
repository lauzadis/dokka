/*
 * Copyright 2014-2023 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    id("dokkabuild.kotlin-jvm")
}

dependencies {
    implementation(projects.dokkaSubprojects.coreTestApi)

    implementation(kotlin("reflect"))
    implementation(kotlin("test"))
}
