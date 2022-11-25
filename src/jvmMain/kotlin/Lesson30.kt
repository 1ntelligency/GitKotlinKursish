import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import lessons.User

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LessonUserList(allUsers: List<User>) {

}

/*
    Весь дизайн можно взять из задания №22, только требуются изменения в логике построения списка:
    allUsers - это исходный, полный, список пользователей.
    Надо создать переменную users, где будут храниться только пользователи, которых ещё не удалили:
    val users = remember { allUsers.toMutableStateList() }
    обратите внимание, что список преобразован в мутируемый (изменяемый) список состояний MutableStateList.

    Также создайте переменную, которая будет определять какой из пользователей в данный момент редактируется:
    var edit: User? by remember { mutableStateOf(null) }
    начальное состояние null, то есть, никакой, все карточки в обычном состоянии.

    Отображайте пользователей с помощью LazyColumn и его items.
    Перед items добавьте одиночный элемент item {}, в который поместите текст подсказки (отступы на 6).

    Горизонтальному ряду внутри карточки добавьте модификатор: combinedClickable(onLongClick = { ... }) { ... }
        первый блок - действие по долгому нажатию элемента. Присвойте здесь переменной edit текущий элемент списка,
        второй блок - действие по обычному нажатию элемента. Присвойте здесь переменной edit значение null
    Долгое нажатие будет запускать редактирование, обычное - отменять.

    Измените структуру: внутри карточки - Box, а уже внутри него - всё остальное, что у вас есть.
    Внутри этого Box, но снаружи горизонтального ряда, на одном с ним уровне добавьте объект AnimatedVisibility(...){}
        первый параметр - "edit == user", то есть объект будет виден только для редактируемого в данный момент элемента,
        второй параметр - модификатор выравнивания (align) по правому нижнему углу карточки (Alignment.BottomEnd),
        последний параметр {} - блок, содержащий кнопку-значок "корзина",
            размер значка 32,
            цвет - MaterialTheme.colors.error
        Кнопка-значок должна делать два действия:
            удалить текущего пользователя из списка: users.remove(user) или просто: users -= user
            обнулить переменную edit: edit = null
*/