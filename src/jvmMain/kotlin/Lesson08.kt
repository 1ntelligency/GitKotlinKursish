import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LessonRadios() {
var color by remember { mutableStateOf(Color.Red) }
    Column {
        Row (verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable { color = Color.Red } )
        {
            RadioButton(color == Color.Red, { color = Color.Red })
            Text("Красный")
        }
        Row (verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable { color = Color.Yellow } )
        {
            RadioButton(color == Color.Yellow, { color = Color.Yellow })
            Text("Жёлтый")
        }
        Row (verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable { color = Color.Green } )
        {
            RadioButton(color == Color.Green, { color = Color.Green })
            Text("Зелёный")
        }
    }
    Column (Modifier.size(200.dp).clip(CircleShape).background(Color.Gray).padding(16.dp),
        verticalArrangement = Arrangement.SpaceEvenly) {
        Box (Modifier.weight(1f).padding(16.dp).aspectRatio(1f)) {
            if (color == Color.Red) color else Color.DarkGray
        }
        Box (Modifier.weight(1f).padding(16.dp).aspectRatio(1f)) {
            if (color == Color.Yellow) color else Color.DarkGray
        }
        Box (Modifier.weight(1f).padding(16.dp).aspectRatio(1f)) {
            if (color == Color.Green) color else Color.DarkGray
        }
    }
}


/*
    Тема - радиокнопки
    Создайте переменную color через связку remember / mutableStateOf типа Color, значение по умолчанию - Color.Red

    Создайте столбец, внутри него - 3 горизонтальных ряда с вертикальным выравниванием по центру
    Каждый ряд содержит радиокнопку и текстовый элемент.
    Первая радиокнопка работает так: RadioButton(color == Color.Red, { color = Color.Red })
    остальные аналогично.

    Чтобы цвет можно было выбрать и нажатием на его название, добавьте каждому горизонтальному ряду модификатор
    обработки нажатия, для первого ряда так: Modifier.clickable { color = Color.Red }

    Светофор рисуется так:
    Создайте столбец с модификаторами обрезки по кругу clip(CircleShape) и цвета фона background(Color.Gray)
        Внутри столбца - три Box (мы их обрежем в кружки). У каждого - цепочка модификаторов:
            вес 1 (чтобы они занимали одинаковое пространство по высоте);
            отступы на 16 (толщина обводки корпуса светофора);
            соотношение сторон 1:1, делается так: .aspectRatio(1f) - чтобы ширина круга была равна его высоте;
            обрезка по кругу;
            цвет фона, у каждого свой, закрашивается по условию, например:
                ЕСЛИ (color == Color.Red) color ИНАЧЕ Color.DarkGray

    Справка:
    https://metanit.com/kotlin/jetpack/4.5.php
*/