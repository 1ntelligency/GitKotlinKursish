import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.*
import ui.LazyColumn

private interface MovieApi {
    /*
    ОТКАЗ ОТ ОТВЕТСТВЕННОСТИ !!! Все данные предоставляет сервис https://www.themoviedb.org/
    Сервис по своей инициативе блокирует подключения из РФ, обращение к нему идёт посредством VPN, поэтому может
    в этом уроке работать медленно или не работать вообще. Автор задания не может проверить и отмодерировать сведения,
    поставляемые сторонним сервисом.
    */
    @GET("discover/movie")
    suspend fun media(@Query("page") page: Int = 1): Movies  // получает одну указанную в page страницу (20 фильмов)

    class Movies(val results: List<Movie>)  // содержит список фильмов Movie
    data class Movie(                       // каждый элемент содержит информацию о фильме
        val id: Int, val title: String, val vote_average: Float, val overview: String, val release_date: String
        // № по БД       название           зрительский рейтинг      описание              дата выхода
    )

    companion object {                      // здесь всё - как обычно, сервер M4 является нашим посредником к API
        fun getApi() = Retrofit.Builder()
            .baseUrl("https://mad.lrmk.ru/medialibrary/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create<MovieApi>()
    }
}

@Composable
fun LessonInfinity() {

}

/*
    Создайте экземпляр API. Продюсер будет немного отличаться, так как нам нужно получить в итоге редактируемый список
    (MutableStateList), чтобы была возможность добавлять в него потом новые записи:
    val movies by produceState(mutableStateListOf()) {
        value = api.media().results.toMutableStateList()
    }
    Начальное значение - пустой редактируемый список, после первого ответа сервера - редактируемый список из 20 фильмов.

    В обычном столбце поместите ленивый столбец с весом 1 для нашего списка фильмов и BottomAppBar для отображения
    статистики и названия сайта.
    Фильм отображается на карточке (отступы 5, закругление и возвышение 10), внутри - столбец с отступами на 10.
    В нём: название, центрированный горизонтальный ряд с вертикальным отступом на 5 и, ниже - текст описания фильма
    тёмно-серым цветом, размером шрифта 12, с выравниванием по ширине.
    В горизонтальном ряду: значок Favorite (правый отступ 5), рейтинг (вес 1), значок DateRange (правый отступ 5) и
    год выхода (можете вырезать первые 4 цифры года функцией .substringBefore('-')), все элементы в ряду - серого цвета.

    В этот раз обязательно создайте переменную state = rememberLazyListState() и примените её к ленивому списку - она
    понадобится для загрузки новых страниц.

    Создайте также целую переменную page - номер страницы, по умолчанию = 1.

    После создания этих переменных поместите конструкцию, которая будет делать всю работу по добавлению данных:
    LaunchedEffect(state.firstVisibleItemIndex) {           // при любом изменении позиции прокрутки списка фильмов
        if (page * 20 - state.firstVisibleItemIndex < 10)   // если мы докрутили до середины последнего блока 20 фильмов
            movies += api.media(page = ++page).results      // увеличить номер страницы page, догрузить ещё 20 элементов
    }                                                       // и добавить их в конец редактируемого списка movies.

    Так как запрос к стороннему сервису - вещь ненадёжная, и может закончиться ошибкой, поэтому правильно будет
    немного доработать этот блок (в этом задании это необязательно, но желательно для надёжности работы приложения):
        if (page * 20 - state.firstVisibleItemIndex < 10) try {
            movies += api.media(page = ++page).results      // если всё в порядке, фильмы добавляются в список.
        } catch (_: Exception) {
            page--          // в случае проблемы с сервером или интернетом номер страницы уменьшается обратно.
        }

    Содержимое BottomAppBar добавьте сами. Три элемента с отступами на 10. Используются символы ∑ и 👁.
    Общее количество загруженных с сервера элементов = movies.size
    Номер первого видимого на экране элемента = state.firstVisibleItemIndex + 1
    Количество видимых на экране элементов = state.layoutInfo.visibleItemsInfo.size
 */