import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable//icon - сам значок, который нужно нарисовать на кнопке
fun ExitMenu(icon: ImageVector, exit: ()->Unit) = Box {
    // var open ...
    IconButton({ }) { Icon(icon, null) }
    // DropdownMenu( ...
}
/*  Это шаблон функции ExitMenu, которую мы будем использовать в этом и следующем уроках для сокращения количества кода.
    Сама функция является коробкой Box, в которой нужно создать выпадающее меню (см. урок №15)
    Нужна переменная (через remember, mutableStateOf) логического типа, начальное значение - ложь.
    Добавьте кнопку-значок  (IconButton), делающую переменную истинной. Сам значок (Icon) взять из параметра icon.
    Добавьте выпадающее меню (DropdownMenu) с этой переменной,
        внутри меню - единственный элемент (DropdownMenuItem), выполняющий действие exit,
            в нём изображён значок "выход из приложения" и текстовая надпись с отступами на 6.
*/

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LessonTopBar(exit: ()->Unit) {
    ExitMenu(Icons.Default.Menu, exit)  // это полежит здесь, пока не закончите функцию выше.

}
/*  Добавьте верхнюю панель TopAppBar {...} с параметрами:
        title = { Текст заголовка экрана },
        navigationIcon = { Здесь должна быть кнопка меню ≡. Просто перенесите сюда вызов функции ExitMenu },
        actions = { Две кнопки-значка: "Поиск", она ничего не делает ({}), и "Закрыть", закрывает программу (exit) },
        и ещё поменяйте цвет фона верхней панели, применив основной цвет контейнера:
        colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.primaryContainer)
*/

