import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun LessonExtAction(exit: ()->Unit) {

}

/*
    Почти то же самое, элемент ExtendedFloatingActionButton({ текст }, { значок }, действие)
    Первый параметр - блок {}, внутри которого - текстовый элемент надписи,
    Второй - блок {}, внутри которого значок закрытия,
    Третий - действие по нажатию (exit)
*/