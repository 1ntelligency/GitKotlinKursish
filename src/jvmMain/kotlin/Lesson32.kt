import androidx.compose.foundation.layout.Box
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun LessonExtAction(exit: ()->Unit) = Box(contentAlignment = Alignment.BottomEnd) {

}

/*
    Почти то же самое, элемент ExtendedFloatingActionButton({ текст }, действие, icon = { значок })
    Первый параметр - блок {}, внутри которого текстовый элемент надписи,
    Второй - действие по нажатию (exit),
    Третий - блок {}, внутри которого значок закрытия
*/