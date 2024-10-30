import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LessonSliders() {
    var red by remember { mutableStateOf(0f) }
    var green by remember { mutableStateOf(0f) }
    var blue by remember { mutableStateOf(0f) }

    Column {
        Slider(value = red, onValueChange = { red = it })
        Slider(value = green, onValueChange = { green = it })
        Slider(value = blue, onValueChange = { blue = it })

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)  // Квадрат
                .background(Color(red, green, blue))
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray)
        ) {
            Text(
                text = (red * 100).toInt().toString() + "%",
                modifier = Modifier
                    .weight(1f)
                    .background(Color.Red)
                    .padding(8.dp),
                textAlign = TextAlign.Center
            )
            Text(
                text = (green * 100).toInt().toString() + "%",
                modifier = Modifier
                    .weight(1f)
                    .background(Color.Green)
                    .padding(8.dp),
                textAlign = TextAlign.Center
            )
            Text(
                text = (blue * 100).toInt().toString() + "%",
                modifier = Modifier
                    .weight(1f)
                    .background(Color.Blue)
                    .padding(8.dp),
                textAlign = TextAlign.Center
            )
        }
    }
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