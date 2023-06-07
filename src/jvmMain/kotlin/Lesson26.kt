import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import lessons.fruits
import ui.LazyVerticalGrid

@Composable
fun LessonVGrid(fruits: List<Pair<String, String>>) {

}

/*
    Снова 4000 фруктов, но попробуем разместить их не столбцом или строкой, а сеткой с заданным количеством рядов.
    Главный элемент - "ленивая" вертикальная сетка - LazyVerticalGrid,
        первый её параметр теперь обязателен - указываем: "фиксированно в три столбца" - GridCells.Fixed(3)
    Внутри сетки - такой же блок items, как и раньше,
        внутри - карточка, отступы на 5, окружность, возвышение на 10,
            внутри - картинка, кликабельная.

    Поскольку имя фрукта здесь не используется, в качестве основного блока можете указать:
    items(fruits) { ( picture, _ ) -> ... }
    от элемента в блоке останется только picture (рисунок) а его название (name) мы заменили на "_" - не используется.
*/