import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable   // colors - список (List) из пар (Pair) значений - строки (String) и цвета (Color)
fun LessonSimple(colors: List<Pair<String, Color>>) {

}

/*
    colors - список типа listOf( "Белый" to Color.White, "Чёрный" to Color.Black, и т.д. )
    Нужно вывести все названия стандартных цветов из этого списка соответствующим цветом.
    Для этого используйте обычный цикл. Варианты написания:
    colors.forEach { используем в этом блоке параметр it в качестве элемента списка }
    или
    colors.forEach { color -> используем в этом блоке параметр color в качестве элемента списка }
    или
    for (color in colors) { используем в этом блоке параметр color в качестве элемента списка }

    Выберите вариант, который больше нравится, и поместите его внутри элемента Column.
    Внутри блока цикла поместите текстовый элемент, чтобы вывести каждое название нужным цветом

    Поскольку каждый элемент - "пара" - Pair<String, Color>, обращаться к ним можно по свойствам first и second:
    название цвета будет it.first или color.first, сам цвет будет it.second или color.second
*/
