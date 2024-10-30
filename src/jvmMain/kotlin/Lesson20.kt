import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ui.verticalScroll

@Composable    // fruits - список пар значений: first - ресурс изображения (типа R.drawable.p1), second - имя картинки
fun LessonColumns(fruits: List<Pair<String, String>>) {
    val fruits = listOf(
        R.drawable.p1 to "Яблоко",
        R.drawable.p2 to "Груша",
        R.drawable.p3 to "Черешня",
        R.drawable.p4 to "Банан",
        R.drawable.p5 to "Лимон",
        R.drawable.p6 to "Клубника",
        R.drawable.p7 to "Нектарин",
        R.drawable.p8 to "Арбуз",
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        fruits.forEach { (fruits, name) ->
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painterResource(fruits),
                    contentDescription = name,
                )
                Text(text = name)

            }
            Divider(Modifier.padding(vertical = 8.dp))
        }
    }
}
/*
    Всё как в предыдущем задании,
    но вместо горизонтального ряда - столбец на всю ширину экрана с центрированием по горизонтали,
    вместо значка - Image, отображающий painterResource от первого компонента пары,
    модификатор отступа на 8 - не у текста, а у разделителя.
*/