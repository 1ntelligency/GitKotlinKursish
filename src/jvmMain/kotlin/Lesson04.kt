import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable      // dossier - текст самого досье, используйте этот параметр в элементе Text
fun LessonJamesBond(dossier: String) {

}

/*
    Это задание будет чуть сложнее.
    Создайте столбец (без круглых скобок), внутри него будет 6 элементов:
    Text заголовка, модификатор выравнивания по центру (Alignment.CenterHorizontally) и отступов на 8, размер шрифта 20
    Три горизонтальных ряда с модификатором отступов на 4, внутри каждого два текста:
        левый  с модификатором веса 1: Modifier.weight(1f) и курсивом: fontStyle = FontStyle.Italic
        правый с модификатором веса 3: Modifier.weight(3f) и полужирным: fontWeight = FontWeight.SemiBold
        пояснение, как работает модификатор веса - по ширине экрана получится так: [ вес 1 ][        вес 3        ]
    Горизонтальный разделитель: Divider()
    Текст досье с модификатором отступа 4, выравнивание по ширине: textAlign = TextAlign.Justify
 */