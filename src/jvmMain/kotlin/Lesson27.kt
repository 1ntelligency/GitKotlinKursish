import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
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
import ui.LazyHorizontalGrid

@Composable
fun LessonHGrid(users: List<User>) {

}

/*
    Всё аналогично предыдущему.
    Но "ленивая" сетка теперь горизонтальная - LazyHorizontalGrid, первый параметр тот же.
    Внутри items - столбец с горизонтальным центрированием,
        внутри столбца - карточка и текстовая подпись серого цвета с нижним отступом на 10.
        Придайте карточке модификаторы:
            отступы на 5,
            вес 1 (чтобы заполнить собой всё свободное пространство ячейки),
        и дополнительный параметр придания карточке формы окружности.
        Внутри карточки - фото пользователя с модификаторами:
            кликабельно - ставится первым в очереди, чтобы визуальный эффект охватывал всю карточку вместе с полями,
            отступы на 10,
            обрезка по окружности.
*/