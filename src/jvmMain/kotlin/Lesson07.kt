import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LessonSwitches() {
    var radio by remember { mutableStateOf(false) }
    var check by remember { mutableStateOf(false) }
    var switch by remember { mutableStateOf(false) }
    var toggle by remember { mutableStateOf(false) }
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                radio, { radio = !radio })
            Text(if (radio) "да" else "нет") }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                check, { check = it })
            Text(if (check) "выбран" else "не выбран") }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Switch(
                switch, { switch = it })
            Text(if (switch) "включен" else "выключен") }

        Row(verticalAlignment = Alignment.CenterVertically) {
            IconToggleButton(
                toggle, { toggle = it }) {
                Icon(
                    Icons.Default.Favorite,
                    "Избранное",
                    tint = if (toggle) MaterialTheme.colorScheme.primary else Color.Gray) }
            Text(if (toggle) "нравится" else "не нравится")
        }
    }
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
            ЕСЛИ (НАЖАТО) MaterialTheme.colorScheme.primary ИНАЧЕ Color.Gray

    Текстовые элементы должны выводить надпись по условию: ЕСЛИ (НАЖАТО) "надпись_да" ИНАЧЕ "надпись_нет"

    Справка:
    https://metanit.com/kotlin/jetpack/4.4.php
    https://metanit.com/kotlin/jetpack/4.5.php
    https://metanit.com/kotlin/jetpack/4.15.php
*/