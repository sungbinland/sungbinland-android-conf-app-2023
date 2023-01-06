/*
 * Designed and developed by Ji Sungbin, 2023
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/sungbinland/conference-web-template
 */

package day.sungbinland.element

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.alignItems
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.flexDirection
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.justifyContent
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun Counter(
    count: Int,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
) {
    Div({
        style {
            height(100.vh)
            backgroundColor(Color.azure)
            display(DisplayStyle.Flex)
            alignItems(AlignItems.Center)
            justifyContent(JustifyContent.Center)
            flexDirection(FlexDirection.Row)
        }
    }) {
        Button(attrs = { onClick { onDecrement() } }) {
            H1 {
                Text("-")
            }
        }
        Span({ style { padding(15.px) } }) {
            H1 {
                Text("$count")
            }
        }
        Button(attrs = { onClick { onIncrement() } }) {
            H1 {
                Text("+")
            }
        }
    }
}
