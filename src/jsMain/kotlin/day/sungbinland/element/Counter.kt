/*
 * Designed and developed by Ji Sungbin, 2023
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/sungbinland/conference-web-template
 */

package day.sungbinland.element

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun Counter(
    count: Int,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
) {
    Div({ style { padding(25.px) } }) {
        Button(attrs = { onClick { onIncrement() } }) {
            Text("-")
        }
        Span({ style { padding(15.px) } }) {
            Text("$count")
        }
        Button(attrs = { onClick { onDecrement() } }) {
            Text("+")
        }
    }
}
