import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ui.verticalScrollHelper

@Composable     // всё так же, только фруктов теперь будет 4000!
fun LessonLongList(fruits: List<Pair<String, String>>) {

}

/*
    Сначала попробуйте скопировать сюда код из задания 21, так как визуально они одинаковы.
    Обратите внимание, что список отображается не очень быстро - нужны большие ресурсы на создание 4000 элементов.
    Выход - использование "ленивого" столбца вместо цикла.

    Вместо Column поставьте LazyColumn, пока без модификаторов, но оставьте ему горизонтальное центрирование.
    Вместо цикла используйте функцию items(...){ ... }, которая создаёт только те элементы, которые помещаются на экран,
    Варианты:
    items(fruits) { используем в этом блоке параметр it в качестве элемента списка }
    или
    items(fruits) { fruit -> используем в этом блоке параметр fruit в качестве элемента списка }

    Остальное - без изменений. Оцените, насколько увеличилась скорость отображения списка.

    Примечание:
    чтобы задействовать здесь прокрутку списка "перетаскиванием", как в телефоне, сделайте так:
        в самом начале функции создайте переменную state = rememberLazyListState()
        первым параметром ленивого столбца укажите модификатор verticalScrollHelper(state)
        вторым параметром укажите сам state. Можно также написать state = state
    Модификатор verticalScrollHelper не является стандартным для Compose, он используется только в этом проекте.
*/