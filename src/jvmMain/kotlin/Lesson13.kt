import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun LessonSliders() {

}

/*
    Создайте три переменных red, green, blue типа Float (число с плавающей точкой), начальное значение - 0f
    Внутри столбца поместите 3 слайдера (Slider) - для каждой из переменных: Slider(переменная, { переменная = it })
    Затем - один Box, на всю ширину экрана, квадратный - aspectRatio(1f), цвет фона - функцией Color(red, green, blue)
    Ниже - горизонтальный ряд на всю ширину, внутри:
        Три текстовых элемента, текст определяем по формуле: (переменная*100).toInt().toString()+"%",
        модификаторы:
            для всех - одинаковый вес, чтобы занять одинаковую ширину,
            укажите цвет фона
            и отступы на 8
        Также укажите им параметр выравнивания текста по центру: textAlign = TextAlign.Center

    Справка:
    https://metanit.com/kotlin/jetpack/4.14.php
*/