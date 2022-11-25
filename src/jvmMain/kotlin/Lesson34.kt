import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data.userName
import java.time.LocalDate

@Composable
fun LessonBottomBar(exit: ()->Unit) = Box(Modifier.fillMaxSize(), Alignment.BottomStart) {

}

/*  Добавьте верхнюю панель BottomAppBar {...},
    внутри её блока {} разместите:
        выпадающее меню со значком ⁝, используя вашу готовую функцию,
        текст подписи с модификатором веса 1f, чтобы остальные кнопки прижались вправо,
        кнопку-значок "Избранное", ничего не делает ({}),
        кнопку-значок "Выход из программы", закрывает программу (exit).
*/