import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable    // fruits - список пар значений: first - ресурс изображения (типа R.drawable.p1), second - имя картинки
fun LessonColumns(fruits: List<Pair<String, String>>) {

}

/*
    Всё как в предыдущем задании,
    но вместо горизонтального ряда - столбец на всю ширину экрана с центрированием по горизонтали,
    вместо значка - Image, отображающий painterResource от первого компонента пары,
    модификатор отступа на 10 - не у текста, а у разделителя.
*/