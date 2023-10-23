import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ui.ElevatedCard
import ui.LazyColumn

@Composable     // всё так же, только фруктов теперь будет 4000!
fun LessonLongList(fruits: List<Pair<String, String>>) {

}

/*
    Сначала попробуйте скопировать сюда код из задания 21, так как визуально они одинаковы.
    Обратите внимание, что список отображается не очень быстро - нужны большие ресурсы на создание 4000 элементов.
    Выход - использование "ленивого" столбца вместо цикла.

    Вместо Column поставьте LazyColumn, без модификаторов, но оставьте ему горизонтальное центрирование.
    Вместо цикла используйте функцию items(...){ ... }, которая создаёт только те элементы, которые помещаются на экран,
    Варианты:
    items(fruits) { используем в этом блоке параметр it в качестве элемента списка }
    или
    items(fruits) { fruit -> используем в этом блоке параметр fruit в качестве элемента списка }

    Остальное - без изменений. Оцените, насколько увеличилась скорость отображения списка.
*/