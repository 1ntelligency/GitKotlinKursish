import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import ui.BackHandler

@Composable
fun LessonDrawer(exit: ()->Unit) {

}

/*
    Создайте 2 переменные:
    val scope = rememberCoroutineScope()
    val state = rememberScaffoldState()
    и, прямо внутри основной функции, чуть ниже переменных, создайте 2 внутренних подпрограммы:
    fun open() = scope.launch { state.drawerState.open() }
    fun close() = scope.launch { state.drawerState.close() }
    первая будет показывать боковое меню, вторая - убирать.

    Создайте Scaffold с верхней панелью, в которой будет единственная кнопка-значок, вызывающая боковое меню:
        IconButton(::open) { Icon(Icons.Default.Menu, null) }
        * обратите ↑ внимание, как указать внутреннюю подпрограмму в качестве действие для кнопки.

    Добавьте в Scaffold параметр scaffoldState = state, чтобы задействовать боковое меню,
    и, следующим параметром, само боковое меню:
        drawerContent = {}
        Внутри этого блока поместите 4 пункта меню и 1 разделитель:
            используйте горизонтальные ряды, чтобы объединить значок и текст:
                на всю ширину, центрирование по вертикали, у значков отступы на 16;
            каждый горизонтальный ряд снабдить модификатором clickable {},
                последний пункт должен вызывать функцию exit(),
                остальные - просто убирать боковое меню.

    Также добавьте где-нибудь снаружи Scaffold обработчик:
        BackHandler(state.drawerState.isOpen) { close() }
        * если меню открыто, кнопка возврата на устройстве просто убирает его, а не закрывает приложение.
*/