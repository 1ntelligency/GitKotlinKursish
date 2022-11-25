import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable//icon - сам значок, который нужно нарисовать на кнопке
fun ExitMenu(icon: ImageVector, exit: ()->Unit) = Box {

}
/*  Это шаблон функции ExitMenu, которую мы будем использовать в этом и следующем уроках для сокращения количества кода.
    Сама функция является коробкой Box, в которой нужно создать выпадающее меню (см. урок №15)
    Нужна переменная (через remember, mutableStateOf) логического типа, начальное значение - ложь.
    Добавьте кнопку-значок  (IconButton), делающую переменную истинной. Сам значок (Icon) взять из параметра icon.
    Добавьте выпадающее меню (DropdownMenu) с этой переменной,
        внутри меню - единственный элемент (DropdownMenuItem), выполняющий действие exit,
            в нём изображён значок "выход из приложения" и текстовая надпись с отступами на 6.
*/

@Composable
fun LessonTopBar(exit: ()->Unit) = Box(Modifier.fillMaxSize()) {
    ExitMenu(Icons.Default.Menu, exit)  // это полежит здесь, пока не закончите функцию выше.
}
/*  Добавьте верхнюю панель TopAppBar {...},
    внутри её блока {} разместите:
        выпадающее меню со значком ≡, используя вашу готовую функцию: ExitMenu(Icons.Default.Menu, exit)
        текст заголовка с модификатором веса 1f, чтобы остальные кнопки прижались вправо,
        кнопку-значок "Поиск", ничего не делает ({}),
        кнопку-значок "Закрыть", закрывает программу (exit).
*/

