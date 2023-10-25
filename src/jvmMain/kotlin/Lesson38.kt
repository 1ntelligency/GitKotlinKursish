import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import ui.BackHandler

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LessonUI(exit: ()->Unit) {

}

/*
    Проверьте свои знания и умения. Постарайтесь максимально точно воспроизвести оригинал, включая логику переходов.

    Создайте переменную, где будете хранить текущее состояние, то есть, какая страница открыта в данный момент,
        и используйте операторы условия if, где это необходимо.

    Боковое меню здесь несколько иное, чем в предыдущем задании: главный элемент называется DismissibleNavigationDrawer,
        внутренний - DismissibleDrawerSheet, но логика построения меню при этом остаётся той же.

    Целиком структура экрана в этом задании будет чуть сложнее:
    Scaffold(
        topBar = {...},
        bottomBar =  {...},
        floatingActionButton = {...}
    ) {
        DismissibleNavigationDrawer(
            DismissibleDrawerSheet(...) { элементы бокового меню },
            Modifier.padding(it), // обязательно, чтобы учесть размеры верхней и нижней панелей
            drawerState = state
        ) {
            Column на всю ширину окна с основным контентом экрана
        }
    }

    Для изменения цвета бокового меню используйте в DismissibleDrawerSheet параметры
        drawerContainerColor = MaterialTheme.colorScheme.secondary,
        drawerContentColor = MaterialTheme.colorScheme.primaryContainer

    Для отключения кнопок (чтобы они были видимы, но неактивны), используйте их параметр enabled = ...

    Отступы значков в боковом меню - 16, размер значка (модификатор size) в рабочей области - 64.
*/