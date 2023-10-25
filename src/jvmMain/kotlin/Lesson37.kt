import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import ui.BackHandler

val menuItems = listOf(
    Icons.Default.Home to "Главная",
    Icons.Default.Favorite to "Лента",
    Icons.Default.Search to "Поиск"
)   // этот список может вам пригодиться для создания элементов меню в цикле

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LessonDrawer(exit: ()->Unit) {

}

/*
    Создайте 2 переменные:
    val scope = rememberCoroutineScope()                // - область выполнения программ в отдельном потоке, и
    val state = rememberDrawerState(DrawerValue.Closed) // - состояние боковой панели (по умолчанию закрыто)
    и, прямо внутри основной функции, чуть ниже переменных, создайте 2 внутренних подпрограммы:
    fun open() = scope.launch { state.open() }
    fun close() = scope.launch { state.close() }
    первая будет показывать боковое меню, вторая - убирать.

    Главным элементом здесь будет ModalNavigationDrawer с тремя параметрами:
        Первый - блок {} с контентом главного меню, мы заполним его на следующем шаге,
        Второй - состояние меню (открыто/закрыто): drawerState = state
        Последний параметр указывается отдельным блоком {} уже после круглых скобок.
        В нём находится контент основной части экрана, на которую должно "наползать" боковое меню.
        Поместите сюда верхнюю панель (TopAppBar), в которой будет единственная кнопка-значок, вызывающая боковое меню:
            IconButton(::open) { Icon(Icons.Default.Menu, null) }
            * обратите ↑ внимание, как указать внутреннюю подпрограмму в качестве действие для кнопки.
        Также установите цвета верхней панели как в уроке №33.

    Теперь перейдём к первому блоку {} нашего ModalNavigationDrawer. Он будет многострочным.
    Поместите сюда элемент ModalDrawerSheet - это само боковое меню.
        Единственный параметр в круглых скобках: модификатор "на всю ширину" со значением 0.75f (3/4 экрана)
        Параметр {} после круглых скобок - здесь будет контент нашего меню.
        Создайте здесь четыре пункта меню (четвёртый - после разделителя).
        Каждый пункт - кликабельный вертикально-центрированный горизонтальный ряд на всю ширину меню,
            содержащий значок с отступом на 16 и текст названия пункта.
        Желательно использовать цикл и список menuItems, находящийся в начале этой страницы.
        Последний пункт по нажатию должен вызывать функцию exit из заголовка этой функции для выхода из приложения,
            остальные - присваивать тексту заголовка экрана новое значение и вызывать функцию close для скрытия меню.

    Также добавьте где-нибудь до или после ModalNavigationDrawer обработчик нажатия кнопки "назад":
        BackHandler(state.isOpen) { close() }
        * если меню открыто, кнопка возврата на устройстве просто закрывает его, а не закрывает приложение.
*/