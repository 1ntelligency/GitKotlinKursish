import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ui.ElevatedCard
import ui.verticalScroll

@Composable
fun LessonCards(fruits: List<Pair<String, String>>) {
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
                .verticalScroll(rememberScrollState())
        ) {
            fruits.forEach { (fruits, name) ->
                ElevatedCard (Modifier.padding(8.dp).align(Alignment.CenterHorizontally))
                { Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painterResource(fruits),
                        contentDescription = name,
                    )
                    Text(text = name, modifier = Modifier.padding(bottom = 8.dp))

                }
            }
        }
    }
}

/*
    Более красивый вариант предыдущего задания. Сначала скопируйте всё оттуда.
    Весь внутренний столбец поместите теперь внутрь нового элемента ElevatedCard (визуально приподнятая карточка)
        с модификатором отступа от краёв экрана на 8,
    Горизонтальный разделитель теперь уберите, а отступ на 8 придайте подписи под картинкой,
        только уточните, что отступать текст будет только от нижней границы карточки: .padding(bottom = 8.dp)
 */