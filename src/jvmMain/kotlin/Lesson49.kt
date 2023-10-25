import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.*
import ui.LazyColumn

private interface LikesApi {
    // Создайте функцию movies без параметров, запрашивающую адрес https://mad.lrmk.ru/media и возвращающую все фильмы:
    // suspend fun...

    data class Movie ( // здесь всё как в прошлом уроке, но добавлен список жанров, к которым принадлежит фильм
        val id: Int, val name: String, val release_date: String, val vote_average: Float, val overview: String,
        val production_countries: String, val genres: List<String>
    )


    @GET("likes")   // Возвращает количество "лайков" указанного фильма
    suspend fun likes(
        @Query("movie") movie: Int,                 // id фильма, берётся из результата первого запроса
        @Query("token") token: String = "lessons"   // user token, это внутренний параметр API уроков, не меняйте его
    ): Like
    // id фильма задаётся первым параметром, второй всегда будет равен "lessons", при вызове функции его не указывайте.


    // Следующий запрос ставит указанному фильму "лайк" или "дизлайк":
    @FormUrlEncoded   // способ кодирования POST-параметров - как в веб-форме. Все параметры объявляются как @Field !!!
    @POST("like")  // запросы, которые что-либо меняют на сервере, обычно оформляются как POST-запросы
    suspend fun like(
        @Field("like") like: Int,                   // +1 - поставить лайк, -1 - дизлайк, 0 - отозвать свой голос
        @Field("movie") movie: Int,                 // id фильма, берётся из результата первого запроса
        @Field("token") token: String = "lessons"   // user token, это внутренний параметр API уроков, не меняйте его
    ): Like           // возвращает изменённое вами количество лайков.


    data class Like (
        val likes: Int = 0,         // количество поставленных фильму "лайков"
        val dislikes: Int = 0,      // количество "дизлайков"
        val your: Int = 0           // конкретно ваш голос (+1, -1 или 0, если не голосовали)
    )

    companion object {
        fun getApi(): LikesApi = Retrofit.Builder()
            .baseUrl("https://mad.lrmk.ru/media/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create()
    }
}

@Composable
fun LessonLikes() {

}

/*
    Создайте экземпляр API и получите список всех фильмов. Аналогично прошлым урокам отобразите "ленивый" столбец
    с карточками фильмов. Только вместо зрительского рейтинга будем отображать кнопки "лайка" и "дизлайка".

    Также появилась строчка с названиями жанров. У фильма теперь есть свойство genres - это список строк, которые
    можно объединить в одну при помощи метода joinToString, пример: it.genres.joinToString(). Размер шрифта 14, серый.

    Каждая карточка будет отдельно запрашивать свою статистику по лайкам. Для этого внутри блока items(){...},
    сразу в его начале, создайте переменную, которая будет отвечать за ваш голос:
        var like by remember { mutableStateOf(LikesApi.Like()) }
    При отображении карточка должна отправить запрос на сервер и отобразить ответ. Следующей командой в этом блоке будет:
        LaunchedEffect(Unit) {       // срабатывает однократно в каждой карточке при её появлении
            like = api.likes(it.id)  // если it - текущий элемент списка фильмов, id - его идентификатор
        }

    В горизонтальном ряду внутри карточки (там, где раньше был зрительский рейтинг), надо отобразить две кнопки-значка
    размером 30dp, для "дизлайка" значок переворачивается вверх ногами модификатором rotate(180f).
    Две текстовые надписи с отступами на 5 отображают количество лайков и дизлайков, которые содержатся в полученной
    с сервера переменной like.

    Все обращения к интернету должны производиться в фоновых потоках. Объявите в начале функции переменную
    scope = rememberCoroutineScope(), она будет использоваться для создания потоков при нажатии кнопок:

    Кнопка "лайк" - если лайк вами уже поставлен, убрать его (0), иначе поставить (1):
        scope.launch {
            like = api.like(if (like.your>0) 0 else 1, it.id)
        }

    Кнопка "дизлайк" - если дизлайк вами уже поставлен, убрать его (0), иначе поставить (-1):
        scope.launch {
            like = api.like(if (like.your<0) 0 else -1, it.id)
        }

    Осталось сделать цвет кнопок. До или после блока LaunchedEffect объявите два значения цвета:
        // если ваш голос положителен, то основной цвет темы, иначе - серый:
        val colorLike = if (like.your>0) MaterialTheme.colorScheme.primary else Color.Gray
        // если ваш голос отрицателен, то цвет ошибки (MaterialTheme.colorScheme.error), иначе - серый:
        val colorDislike = напишите сами...
    Теперь примените эти цвета к соответствующим кнопкам и надписям.
*/