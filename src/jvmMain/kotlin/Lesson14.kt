import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.math.min

@Composable
fun LessonProgress() {
    var text by remember {mutableStateOf("")}
    Column {
        TextField(text, {text = it},
            label = { Text("Ваша работа") },
            modifier = Modifier.fillMaxWidth().aspectRatio(1f),
            placeholder = { Text("Набирайте любой случайный текст") },
            )
        Text("Индикатор усталости:", Modifier.padding(8.dp))
        LinearProgressIndicator(text.length/100f, Modifier.fillMaxWidth())
    }

}

/*
    Создайте пустую текстовую переменную,
    Внутри столбца поместите текстовое поле ввода для этой переменной, на всю ширину экрана, квадратное.
    Усталость вычислите по формуле от длины набранного текста: text.length / 100f
    Ниже - надпись с отступом на 8
    Ниже добавьте LinearProgressIndicator для усталости на всю ширину экрана.

    Справка:
    https://metanit.com/kotlin/jetpack/4.18.php
*/