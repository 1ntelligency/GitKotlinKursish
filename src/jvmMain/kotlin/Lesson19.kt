import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import ui.verticalScroll

@Composable // icons - список (List) из пар (Pair) значений - векторного рисунка (ImageVector) и строки (String)
fun LessonRows(icons: List<Pair<ImageVector, String>>) {

}

/*
    icons - список типа listOf( Icons.Default.Add to "Add",  Icons.Default.Close to "Close", и т.д. )
    Нужно вывести все значки основного пакета Compose вместе с названием.
    Для этого используйте обычный цикл внутри столбца.
        В цикле поместите горизонтальный ряд с центрированием по вертикали,
            внутри - Icon, отображающий first элемент пары,
            и Text, отображающий second элемент, отступ - на 10;
        Разделитель - снаружи горизонтального ряда.

    Для прокрутки экрана по вертикали придайте самому столбцу модификатор прокрутки:
        Modifier.verticalScroll(rememberScrollState())

    Внимание!
    В дальнейшем не будет подсказок, какие значки используется в заданиях, вы всегда можете посмотреть их список здесь.
*/