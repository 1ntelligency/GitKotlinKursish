import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LessonProgress() {

}

/*
    Создайте пустую текстовую переменную,
    Внутри столбца поместите текстовое поле ввода для этой переменной, на всю ширину экрана, квадратное.
    Усталость вычислите по формуле от длины набранного текста: text.length / 100f
    Ниже добавьте LinearProgressIndicator для усталости на всю ширину экрана.

    Справка:
    https://metanit.com/kotlin/jetpack/4.18.php
*/