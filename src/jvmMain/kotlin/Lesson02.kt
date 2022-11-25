import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LessonRow() {

}

/*
    Создайте горизонтальный ряд - Row,
    в круглых скобках укажите порядок размещения и промежутков: horizontalArrangement = Arrangement.SpaceBetween
    затем, в фигурных - три текстовых элемента - Text:
    где первый параметр в круглых скобках - надпись в кавычках,
    второй - модификаторы фонового цвета, а затем отступа на 8 единиц - Modifier.background(Color.Red).padding(8.dp)

    Справка:
    https://metanit.com/kotlin/jetpack/3.1.php
    https://metanit.com/kotlin/jetpack/3.2.php
    https://metanit.com/kotlin/jetpack/3.4.php
    https://metanit.com/kotlin/jetpack/2.3.php
    https://metanit.com/kotlin/jetpack/4.1.php
 */