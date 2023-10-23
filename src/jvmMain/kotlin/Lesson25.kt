import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import lessons.User
import ui.ElevatedCard
import ui.HorizontalPager

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LessonPager(users: List<User>) {

}

/*
    В Compose наконец появился специальный элемент для этой задачи, но он пока (в версии 1.5) считается
        экспериментальным, поэтому перед именем нашей функции стоит предупреждение о его использовании.

    Главный элемент - HorizontalPager, первым параметром должно идти его запомненное состояние с указанием количества
        пользователей в списке: rememberPagerState { users.size }
    Затем идёт блок {}, в котором можно разместить карточку с отступами на 10.

    Внутри карточки - столбец с горизонтальным центрированием, а внутри столбца:
        Возьмите текущего пользователя с номером it из списка:
            val user = users[it]
        Поместите фото пользователя с модификаторами:
            отступы на 15,
            обрезка по фигуре с закруглёнными на 10 углами.
        Текст ФИО пользователя через пробел,
        Текст должности пользователя с нижним отступом на 10, цвет - серый.
*/