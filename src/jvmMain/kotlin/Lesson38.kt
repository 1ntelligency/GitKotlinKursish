import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import ui.BackHandler

@Composable
fun LessonUI(exit: ()->Unit) {

}

/*
    Проверьте свои знания и умения. Постарайтесь максимально точно воспроизвести оригинал, включая логику переходов.

    Создайте переменную, где будете хранить текущее состояние, то есть, какая страница открыта в данный момент,
        и используйте операторы условия if, где это необходимо.

    Для отключения кнопок (чтобы они были видимы, но неактивны), используйте их параметр enabled = ...

    Для изменения цвета бокового меню используйте в Scaffold параметр
        drawerBackgroundColor = MaterialTheme.colors.primaryVariant

    Отступы значков в боковом меню - 16, размер значка (модификатор size) в рабочей области - 64.
*/