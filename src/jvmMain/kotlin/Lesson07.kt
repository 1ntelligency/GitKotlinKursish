import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color

@Composable
fun LessonSwitches() {

}

/*
    Тема - переключатели
    Создайте 4 переменных через связку remember / mutableStateOf логического типа, значение по умолчанию - false:
    var radio by remember { mutableStateOf(false) } // и ещё 3

    Создайте столбец, внутри него - 4 горизонтальных ряда с вертикальным выравниванием
        по центру (verticalAlignment = Alignment.CenterVertically)
    Каждый ряд содержит переключатель и текстовый элемент.

    Переключатели: RadioButton, Checkbox, Switch, IconToggleButton.
    Все переключатели записываются одинаково: Переключатель(переменная, { переменная = новое_значение })

    Радиокнопка не предназначена для использования вне группы радиокнопок, и не даёт своё новое значение,
    поэтому оформляется так: RadioButton(radio, { radio = !radio })
    Остальные могут использовать параметр it для получения нового значения: Checkbox(check, { check = it })

    Для IconToggleButton нужно также указать последний параметр {},
        внутри которого будет Icon, отображающий значок "сердце" - Icons.Default.Favorite,
        цвет значка (параметр tint=) определяется условием:
            ЕСЛИ (НАЖАТО) MaterialTheme.colors.primary ИНАЧЕ Color.Gray

    Текстовые элементы должны выводить надпись по условию: ЕСЛИ (НАЖАТО) "надпись_да" ИНАЧЕ "надпись_нет"

    Справка:
    https://metanit.com/kotlin/jetpack/4.4.php
    https://metanit.com/kotlin/jetpack/4.5.php
    https://metanit.com/kotlin/jetpack/4.15.php
*/