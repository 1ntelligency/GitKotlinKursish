import androidx.compose.animation.*
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.lessonsLogin
import data.lessonsPassword
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.*
import ui.BackHandler
import ui.LazyColumn

private interface InboxApi {
    @FormUrlEncoded    // Поскольку на сервер передаётся пароль, то это POST-запрос. Кодирование как в веб-форме.
    @POST("inbox")  // для получения входящих сообщений указываются логин и пароль пользователя:
    suspend fun inbox(@Field("login") login: String?, @Field("password") password: String?): Messages

    // сервер возвращает JSON типа {messages: [{сообщение1}, {сообщение2}, {сообщение1}]}, поэтому создан класс-контейнер
    data class Messages(val messages: List<Message>)

    data class Message(     // а в элементе этого списка находятся все данные об одном сообщении:
        val id: Int, val from: String, val name: String, val position: String, val avatar: String,
        val title: String, val message: String, val sent: String
    )

    companion object {
        fun getApi(): InboxApi = Retrofit.Builder()
            .baseUrl("https://mad.lrmk.ru/mail/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create()
    }
}

@Composable  // avatars - список аватарок пользователей, хранящихся в ресурсах этого проекта.
fun LessonInbox(avatars: List<String>) {

}

/*
    Для этого задания нам потребуется авторизация на сервере. Убедитесь, что в предыдущем задании вы присвоили значение
    логина и пароля встроенным глобальным переменным задачника lessonsLogin и lessonsPassword. Если что-то не так,
    пройдите авторизацию ещё раз. Создайте экземпляр API и получите через продюсер список сообщений:
        api.inbox(lessonsLogin, lessonsPassword).messages.reversed()
    как видите, на сервер отправляются ваши сохранённые логин и пароль, полученный список сообщений разворачивается
    наоборот (reversed), так, чтобы последнее пришедшее сообщение стало первым в списке.

    Как обычно, отобразите в ленивом столбце все сообщения в виде карточек (отступы 5).
    У аватарки отступы 5, размер 48 и обрезка. Для упрощения мы не загружаем аватарки с сервера, а берём из ресурсов
    приложения. Поэтому, прежде чем отображать картинку, желательно убедиться, что такая есть: it.avatar in avatars.
    У текстового столбца отступы 5, у адреса и даты размер шрифта 12, серый цвет.

    Теперь нужно запрограммировать открытие сообщения. В начале программы создайте переменную message типа
    InboxApi.Message, которая может быть null, начальное значение null. В ней будем сохранять выбранное пользователем
    сообщение, null означает, что все сообщения закрыты. Сразу же оформите BackHandler для этой переменной, чтобы кнопка
    "назад" закрывала сообщение.

    Элементу Row внутри карточки сообщения назначьте clickable, присваивающий всё текущее сообщение переменной message.

    Весь наш ленивый столбец теперь поместите внутрь Box, а после столбца, но внутри этого же бокса добавьте элемент
    AnimatedVisibility, чтобы он открывался прямо поверх нашего списка сообщений. Элемент виден, когда message не null.
    Выравнивание - по центру бокса. Анимация входа - expandIn { IntSize.Zero } (увеличение от нулевого размера).

    Выбранное сообщение message может быть null, поэтому внутри AnimatedVisibility поместите конструкцию
    message?.let {...}, внутри которой, обращаясь через "it" к выбранному пользователем сообщению, оформите карточку
    для отображения всего письма, отступы на 15. Внутренняя структура - самостоятельно:
    отступы аватарки и столбца с именем/адресом на 5, темы и основного текста на 15. Размер аватарки 48, размер шрифта
    имени/должности 14, адреса и даты - 12. Основной текст сделайте выделяемым (SelectionContainer).
    Слово "Тема" серым цветом можно добавить к тексту темы таким образом:
        val tema = buildAnnotatedString {
            withStyle(SpanStyle(Color.Gray)) { append("Тема: ") }
            append(it.title)
        }

    Кнопка-значок для закрытия размещается прямо внутри карточки сообщения с выравниванием вверх-вправо после всего
    содержимого карточки. Кнопка, разумеется, присваивает null нашей переменной message.

    После этого AnimatedVisibility добавьте ещё один, с теми же настройками, но с выравниванием вниз экрана.
    Внутри - карточка, отступы 5. В ней - две кнопки-значка для перелистывания сообщений
    влево-вправо и текст с номером открытого сообщения (вычисляется так: messages.indexOf(message) + 1) и общим их
    количеством (messages.size). Кнопка "влево2 программируется примерно так:
        val i = messages.indexOf(message)       // нашли номер текущего по списку,
        if (i > 0) message = messages[i - 1]    // проверили, что мы не в начале списка, и переключились на предыдущее.
    Кнопка "вправо" - самостоятельно.

    ... Дополнительная анимация и затемнение при открытии сообщения ...

    Создайте в начале программы ещё две Float-переменных, зависящих от состояния message (null она, или не null):
    val alpha by animateFloatAsState(if (message == null) 1f else 0.3f)                 // прозрачность элементов
    val back by animateColorAsState(if (message == null) Color.White else Color.Gray)   // цвет фона окна
    Цвет фона примените непосредственно к Box, в котором находится всё содержимое, а прозрачность - к карточкам
    заголовков сообщений внутри ленивого столбца.
*/