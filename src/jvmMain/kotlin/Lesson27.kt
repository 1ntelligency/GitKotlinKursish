import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.CircleShape
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
import ui.horizontalScrollHelper

@Composable
fun LessonHGrid(users: List<User>) {

}

/*
    Всё аналогично предыдущему.
    Но "ленивая" сетка теперь горизонтальная - LazyHorizontalGrid, первый параметр тот же.
    Внутри items - столбец с горизонтальным центрированием,
        внутри столбца - карточка и текстовая подпись серого цвета с НИЖНИМ отступом на 10: .padding(bottom = 10.dp)
        Придайте карточке модификаторы:
            отступы на 5,
            вес 1 (чтобы заполнить собой всё свободное пространство ячейки)
        и дополнительные параметры:
            второй - закругление углов карточки до состояния окружности,
            возвышение на 10.
        Внутри карточки - фото пользователя с модификаторами:
            кликабельно - ставится первым в очереди, чтобы визуальный эффект охватывал всю карточку вместе с полями,
            отступы на 10,
            обрезка по окружности.

    Примечание:
    чтобы задействовать здесь горизонтальную прокрутку списка колесом и "перетаскиванием", как в телефоне, сделайте так:
        в самом начале функции создайте переменную state = rememberLazyListState()
        первым параметром ленивого ряда укажите модификатор horizontalScrollHelper(state)
        вторым параметром укажите сам state. Можно также написать state = state
    Модификатор horizontalScrollHelper не является стандартным для Compose, он используется только в этом проекте.
*/