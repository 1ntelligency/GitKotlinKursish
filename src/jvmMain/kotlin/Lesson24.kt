import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lessons.fruits
import ui.LazyRow

@Composable
fun LessonLongRow(fruits: List<Pair<String, String>>) {

}

/*
    Всё аналогично предыдущему.
    Но вместо "ленивого" столбца - "ленивый" ряд - LazyRow, параметры прокрутки и центрирования сейчас не нужны.
    Внутри items - столбец с горизонтальным центрированием,
        внутри столбца - карточка и текстовая подпись серого цвета, размер шрифта 14.
        Придайте карточке модификаторы:
            fillParentMaxWidth(1/3f) - чтобы она заняла ровно 1/3 ширины экрана,
            отступы на 10,
        и дополнительные параметры:
            второй - закругление углов карточки до состояния окружности (CircleShape),
            возвышение на 10.
        Внутри карточки - только сам рисунок, модификатор clickable теперь следует применять к нему.

    Попробуйте ещё один вариант написания функции items:
    items(fruits) { (picture, name) -> ... }
    в этом случае ресурс картинки будет просто picture, а не it.first, а текст подписи - просто name, а не it.second,
    это возможно, так как каждый элемент списка фруктов - это пара значений, и её можно таким образом разбить.
*/