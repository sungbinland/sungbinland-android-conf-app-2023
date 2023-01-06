/*
 * Designed and developed by Ji Sungbin, 2023
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/sungbinland/conference-web-template
 */

package day.sungbinland.utils

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.DOMScope
import org.jetbrains.compose.web.renderComposable
import org.w3c.dom.Element

fun setContent(content: @Composable DOMScope<Element>.() -> Unit) {
    renderComposable(rootElementId = "root", content = content)
}
