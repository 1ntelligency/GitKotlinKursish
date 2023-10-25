import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.lessonsLogin
import data.lessonsPassword
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import ui.LazyColumn

private interface OutboxApi {
    // Создайте функцию outbox для получения списка отправленных сообщений по адресу https://mad.lrmk.ru/mail/outbox,
    // все параметры и структура возвращаемого значения в точности как в задании №52.
    // Создайте также по памяти объект-компаньон и функцию getApi() для этого интерфейса.

}

@Composable
fun LessonSent() {

}

/*
    Получите список отправленных сообщений messages, последнее отправленное должно идти в начале списка.
    Объявите переменную message, предназначенную для хранения одного такого сообщения, начальное значение - null.

    Отобразите список сообщений, вместо карточек - clickable-столбцы с отступами на 5.
    После этого столбца - AnimatedVisibility, видимый, когда переменная message равна текущему сообщению, анимации -
    увеличение/уменьшение по вертикали: expandVertically{0} и shrinkVertically{0}.
    Внутри - SelectionContainer с текстом сообщения (отступы на 5). Размеры шрифтов - 12 и 14. Цвета - обычный и серый.

    Щелчок по сообщению должен его сворачивать/разворачивать (управляется переменной message), напишите самостоятельно.
*/