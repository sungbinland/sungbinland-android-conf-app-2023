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
import day.sungbinland.utils.setContent

fun main() {
    var count by mutableStateOf(0)

    setContent {
        Counter(
            count = count,
            onIncrement = { count++ },
            onDecrement = { count-- },
        )
    }
}
