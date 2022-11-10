import androidx.compose.material.Text
import lessons.Lessons
import lessons.bond
import ui.mainUI

fun main() = mainUI {
    when(it) {
        Lessons.Hello -> Begin(bond)
        Lessons.More -> { Text("Продолжение") }
        Lessons.End -> { Text("Завершение") }
        //else -> {}
    }
}
