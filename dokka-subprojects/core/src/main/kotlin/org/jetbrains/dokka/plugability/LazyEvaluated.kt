/*
 * Copyright 2014-2023 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
 */

package org.jetbrains.dokka.plugability

internal class LazyEvaluated<T : Any> private constructor(private val recipe: ((DokkaContext) -> T)? = null, private var value: T? = null) {

    @Synchronized
    internal fun get(context: DokkaContext): T {
        if(value == null) {
            value = recipe?.invoke(context)
        }
        return value ?: throw AssertionError("Incorrect initialized LazyEvaluated instance")
    }

    companion object {
        fun <T : Any> fromInstance(value: T) = LazyEvaluated(value = value)
        fun <T : Any> fromRecipe(recipe: (DokkaContext) -> T) = LazyEvaluated(recipe = recipe)
    }
}
