import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data.userName
import java.time.LocalDate

@Composable
fun LessonBottomBar(exit: ()->Unit) {

}

/*  Добавьте нижнюю панель BottomAppBar {...},
    внутри её блока {} разместите:
        выпадающее меню со значком ⁝ , используя вашу готовую функцию ExitMenu из прошлого урока,
        текст подписи с модификатором веса 1f, чтобы остальные кнопки прижались вправо,
        кнопку-значок "Избранное", ничего не делает ({}),
        кнопку-значок "Выход из программы", закрывает программу (exit).
    Самой панели в круглых скобках задайте параметр цвета фона главного контейнера:
        containerColor = MaterialTheme.colorScheme.primaryContainer
*/