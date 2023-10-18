import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable    // Используйте exit в качестве параметра-действия для кнопки выхода
fun LessonRegForm(exit: ()->Unit) {

}

/*
    Пришло время проверить свои знания и умения. Создайте форму регистрации (пока не рабочую, только дизайн).

    Ключевые слова для напоминания: четыре переменные, столбец с горизонтальным выравниванием, размер шрифта (20),
    поля ввода, модификаторы отступа (на 4), горизонтальные ряды, радиокнопки, кнопка, текстовая кнопка...

    Переменную "пол" можно сделать, например, числовой, где 1=мужчина, 2=женщина, 0=не выбран.
    На кнопке регистрации - значок Icons.Default.Check

    После "с правилами ознакомлен" в случае мужского пола выводится пробел, в случае женского - буква "а"
*/