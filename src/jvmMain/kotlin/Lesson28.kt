import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lessons.User

@Composable // chat - "генератор бреда", список пар "пользователь-случайнаяФраза"
fun LessonChat(chat: List<Pair<User, String>>) {

}

/*
    Попробуйте применить все свои знания на этом конкретном примере.
    Примечания по дизайну:
    Строка с именем пользователя - высотой в 30.
        Фото аватара с горизонтальным отступом: horizontal = 8.dp
        ФИО пользователя - серым цветом, размер шрифта 14
    Карточка:
        с отступами снизу и сбоку: bottom = 15.dp, start = 5.dp, end = 5.dp,
        закругление краёв и возвышение - на 10,
    Текст сообщения:
        отступы на 10,
        чтобы текст можно было скопировать, заключите его внутрь SelectionContainer {...}

    Как сделать автопрокрутку к последнему сообщению при его появлении?
        Создайте переменную val state = rememberLazyListState()
        и используйте её как параметр для ленивого столбца.
        Ниже или выше самого элемента столбца добавьте лаунчер события:
        LaunchedEffect(chat.size) { state.animateScrollToItem(chat.size) }
        то есть, при каждом изменении количества сообщений будет происходить анимированная прокрутка к последнему.
*/