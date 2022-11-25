import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

private val buttons = listOf(   // это может вам пригодиться:
    "Обычная кнопка", "Закруглённая кнопка", "Кнопка с окантовкой", "Текстовая кнопка", "Кнопка-значок", "Круглая кнопка"
)

@Composable
fun LessonButtons() {

}

/*
    Тема - различные виды кнопок.
    Создайте столбец, в круглых скобках укажите выравнивание по центру (horizontalAlignment = Alignment.CenterHorizontally)
    затем, в фигурных - различные типы кнопок.
    Во-первых, создайте текстовую переменную через связку remember / mutableStateOf, как это требует Jetpack Compose:
    var text by remember { mutableStateOf("Нажмите любую кнопку:") }
    и следующей строкой выведите этот Text.
    Первая кнопка - обычная, Button(первый параметр) { последний параметр }
        Первый параметр - что эта кнопка делает, например, ({ text = buttons[0] })
        Последний параметр - что написано/нарисовано на кнопке:
            это значок "домик": Icon(Icons.Default.Home, "Домой")
            и Text для кнопки, например, buttons[0]
    Вторая кнопка - аналогично первой, только без значка и с надписью buttons[1],
        но вторым параметром добавьте модификатор обрезки краёв кнопки по кругу: Modifier.clip(CircleShape)
    Третья кнопка - OutlinedButton вместо Button
    Четвёртая - TextButton
    Пятая - IconButton, внутри которой только значок "домик".
        Покрасьте его основным цветом темы добавив в Icon третий параметр: tint = MaterialTheme.colors.primary
    Шестая - то же самое, только tint белый, а самой IconButton добавьте модификатор обрезки по кругу и цвета фона:
        модификатор clip(CircleShape) а после него background(MaterialTheme.colors.primary)

    Справка:
    https://metanit.com/kotlin/jetpack/4.2.php
 */