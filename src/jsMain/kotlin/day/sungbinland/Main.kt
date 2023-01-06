/*
 * Designed and developed by Ji Sungbin, 2023
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/sungbinland/conference-web-template
 */

/*
 * Designed and developed by Ji Sungbin, 2023
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/sungbinland/conference-web-template
 */

package day.sungbinland

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import day.sungbinland.element.Counter
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposable

fun main() {
    var count by mutableStateOf(0)

    renderComposable(rootElementId = "root") {
        Counter(
            count = count,
            onIncrement = { count++ },
            onDecrement = { count-- },
        )
    }
}
