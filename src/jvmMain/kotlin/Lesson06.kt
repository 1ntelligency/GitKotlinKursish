import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ElevatedButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun LessonImages() {
    var file by remember { mutableStateOf(R.drawable.p1) }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painterResource(R.drawable.p1), "Яблоко")

        Row(modifier = Modifier.fillMaxWidth()) {
            ElevatedButton(
                onClick = { file = R.drawable.p1 },
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .padding(3.dp)
            ) {
                Image(painter = painterResource(R.drawable.p1), contentDescription = "Яблоко")
            }


            ElevatedButton(
                onClick = { file = R.drawable.p2 },
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .padding(3.dp)
            ) {
                Image(painter = painterResource(R.drawable.p2), contentDescription = "Груша")
            }
            ElevatedButton(
                onClick = { file = R.drawable.p3 },
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .padding(3.dp)
            ) {
                Image(painter = painterResource(R.drawable.p3), contentDescription = "Вишня")
            }
        }
    }
}





/*
    Тема - вывод на экран изображений и кнопки-картинки.
    Картинки, встроенные в ресурсы проекта в Android обозначаются так: R.drawable.имяФайла
    В этом задании: R.drawable.p1 - яблоко, R.drawable.p2 - груша, R.drawable.p3 - черешня
    В Jetpack Compose ресурс можно извлечь функцией painterResource(R.drawable...) и отобразить его в элементе Image.

    Создайте переменную file через связку remember / mutableStateOf - это будет имя выбранной картинки:
    var file by remember { mutableStateOf(R.drawable.p1) }

    Создайте столбец с горизонтальным выравниванием по центру, внутри него - выбранное изображение:
        Image(painterResource(file), "фрукт")
        а ниже - горизонтальный ряд из трёх ElevatedButton, на каждой с помощью Image изображён свой фрукт,
            и каждая кнопка при нажатии присваивает переменной file имя своего ресурса
        Каждой ElevatedButton добавьте модификатор веса 1, чтобы вместе они заняли всю ширину экрана,
            а также модификатор aspectRatio(1f) чтобы их ширина была равна высоте (получатся круги вместо овалов),
            и модификатор отступа на 3.

    Справка:
    https://metanit.com/kotlin/jetpack/6.1.php
 */