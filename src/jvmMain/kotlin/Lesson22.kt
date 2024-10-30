import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import lessons.User
import org.jetbrains.skia.Image
import ui.ElevatedCard
import ui.verticalScroll

private data class User(  // класс "Пользователь", список которых нужно отобразить
    val surName: String, val firstName: String, val lastName: String, // ФИО пользователя
    val position: String, // должность пользователя
    val photo: String     // ресурс с фотографией пользователя (типа R.drawable.u01)
)

@Composable  // users - список пользователей класса User
fun LessonUsers(users: List<User>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        users.forEach { user ->
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .clickable {},
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(user.photo),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(10.dp)
                            .clip(CircleShape)
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(10.dp),
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(text = user.surName)
                        Text(text = "${user.firstName} ${user.lastName}")
                        Divider()
                        Text(text = user.position, color = Color.Gray)
                    }
                }
            }
        }
    }
}

/*
    Пришло время посмотреть, чему мы научились.
    Приподнятая карточка с отступами на 5,
        внутри - горизонтальный ряд с модификатором высоты (height) 100, на всю ширину экрана,
            внутри - фото пользователя с модификаторами отступов на 10 и обрезки по окружности .clip(CircleShape),
            и столбец с отступами на 10, на всю высоту ряда, второй его параметр = Arrangement.SpaceEvenly,
                внутри три текста с разделителем. Последний текст - серым цветом.

    Чтобы визуальный эффект нажатия на карточку работал правильно, модификатор .clickable{} следует применять
        к элементу непосредственно внутри карточки - то есть, к горизонтальному ряду
*/