import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
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
import retrofit2.http.GET
import retrofit2.http.Query
import ui.LazyColumn

private interface SearchApi {
    // Создайте функцию movies, запрашивающую адрес https://mad.lrmk.ru/media и возвращающую список элементов Movie.
    // У функции один строковый параметр search - строка для поиска фильма по его названию. Не может быть null:
    // suspend fun...

    data class Movie ( // здесь всё как в прошлом уроке
        val id: Int, val name: String, val release_date: String, val vote_average: Float, val overview: String,
        val production_countries: String
    )

    companion object {
        fun getApi(): SearchApi = Retrofit.Builder()
            .baseUrl("https://mad.lrmk.ru/media/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create()
    }
}

@Composable
fun LessonSearch() {

}

/*
    Создайте экземпляр API. Мы не будем отправлять запрос на сервер при вводе каждой буквы в строке поиска, он будет
    производиться только по нажатии специальной кнопки. Поэтому ниже объявите две строковые переменные:
    text (начальное значение - пустая строка) для пользовательского ввода в строку поиска,
    search (начальное значение - строка "none" или любая комбинация букв) непосредственно для запроса на сервер.

    Именно переменная search будет ключом нашего продюсера, при её изменении будет запрашиваться список фильмов:
    val movies by produceState(emptyList(), search) {
        value = api.movies(search).sortedByDescending { it.vote_average }
    }
    Поскольку начальное значение переменной - "none", а таких названий в базе точно нет, то список поначалу будет пуст.

    Теперь создайте простй столбец, первым в него поместите TextField на всю ширину, в одну строку, размер шрифта
    textStyle = TextStyle(fontSize = 20.sp), также есть строка-шаблон серого цвета. Должно менять переменную text.
    leadingIcon = кнопка сброса, должна очищать обе переменные,
    trailingIcon = кнопка поиска, должна присваивать переменной search значение строки text.

    Далее в этом столбце идёт список фильмов, как в предыдущем задании.
*/