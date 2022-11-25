import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun LessonCards(fruits: List<Pair<String, String>>) {

}

/*
    Более красивый вариант предыдущего задания. Сначала скопируйте всё оттуда.
    Внутренний столбец поместите теперь внутрь нового элемента Card - карточка, с параметрами:
        первый - модификатор отступа от краёв экрана на 10,
        второй - закругление углов карточки на 20: RoundedCornerShape(20.dp),
        предпоследний - "возвышение" над поверхностью на 10, с показом "тени": elevation = 10.dp,
        последний - блок {}, в котором и находится ваш столбец с рисунком и текстом.
    Горизонтальный разделитель теперь уберите, а отступ на 10 придайте подписи под картинкой.
 */