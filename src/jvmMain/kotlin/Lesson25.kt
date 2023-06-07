import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import lessons.User
import ui.horizontalSnapHelper

@Composable
fun LessonPager(users: List<User>) {

}

/*
    В следующих версиях Compose должен появиться специальный элемент для этой задачи, но пока мы вполне
    обойдёмся обычным "ленивым" горизонтальным рядом, как в прошлом задании, только нужно установить
    размер одного элемента ровно по ширине экрана.

    Итак, ленивый ряд, и внутри блока items - карточка с модификаторами:
        по ширине самого ряда - fillParentMaxWidth()
        отступы на 10
    и дополнительными параметрами:
        закругление углов карточки на 20,
        возвышение на 10.
    Внутри карточки - столбец с горизонтальным центрированием, а внутри столбца:
        Фото пользователя с модификаторами:
            отступы на 15,
            обрезка по той же фигуре, что и карточка;
        Текст ФИО пользователя через пробел,
        Текст должности пользователя с отступами на 10, цвет - серый.

    Примечание:
    чтобы задействовать здесь горизонтальную прокрутку списка с автовыравниванием сделайте так:
        в самом начале функции создайте переменную state = rememberLazyListState()
        первым параметром ленивого ряда укажите модификатор horizontalSnapHelper(state)
        вторым параметром укажите сам state. Можно также написать state = state
    !!! Модификатор horizontalSnapHelper не является стандартным для Compose, он используется только в этом проекте !!!
*/