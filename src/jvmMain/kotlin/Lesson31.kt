import androidx.compose.foundation.layout.Box
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun LessonAction(exit: ()->Unit) = Box(contentAlignment = Alignment.BottomEnd) {

}

/*
    Элемент "кнопка действия": FloatingActionButton(...) { ... }
    В круглых скобках укажите действие в случае нажатия кнопки (exit)
    В фигурных - значок закрытия приложения (список всех базовых значков в задании №19)
*/