import R.drawable
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.*
import ui.BackHandler
import ui.verticalScrollHelper
import java.text.DecimalFormat

private interface WeatherApi {
    // Данные предоставляются сервисом https://openweathermap.org/ и за их точность автор урока ответственности не несёт.

    // Самостоятельно опишите функцию cities(), производящую GET-запрос по адресу https://mad.lrmk.ru/kladr/city
    // и возвращающую список городов, используя класс City (этот класс создайте сами, он состоит из двух строковых
    // значений: type (может быть null) и city (не может быть null))
    // @GET("kladr/city")
    // ...

    // Самостоятельно опишите функцию weather(query: String), производящую GET-запрос по адресу
    // https://mad.lrmk.ru/weather/weather?q=YYY с параметром по имени "q", где YYY - название города
    // и возвращающую текущую погоду в этом городе, используя класс Weather
    // @GET("weather/weather")
    // ...

    data class Weather(
        val main: Main,
        val weather: List<Weather>
    ) {
        data class Main(val temp: Double)
        data class Weather(val description: String)
    }

    companion object {
        fun getApi() = "попробуйте по памяти построить интерфейс WeatherApi для API сервера https://mad.lrmk.ru/"
    }
}

@Composable
fun LessonWeatherCities() {

}

/*
    Создайте экземпляр нашего API (помните remember!). Создайте продюсер, который получит у нашего API список городов.
    Назовите этот список all (все города). Помимо этого создайте редактируемый список городов с начальными данными:
    val cities = remember { mutableStateListOf("Москва", "Санкт-Петербург", "Лермонтов") }

    Создайте логическую переменную choose, отвечающую за показ списка городов для их выбора.
    Создайте два анимированных (с вертикальным сдвигом) блока для двух случаев, когда choose истинна и не истинна.

    В первом случае отобразите ленивый список названий всех (all) городов с чекбоксами.
    Размер чекбокса ограничить 32.dp, у текста задать отступы на 10.
    Чекбокс активен, когда город выбран, то есть содержится в списке cities, условие пишется так: city in cities
    По нажатию чекбокса надо или включить этот город в список (cities += city), или исключить из него (cities -= city).

    Во втором случае отобразите ленивый список только выбранных городов (cities). В качестве элемента списка
    просто оформите вызов функции: WeatherCity(api, it) - она находится чуть ниже, и мы доделаем её чуть позже.

    Последним элементом этого списка добавьте item{...} в котором будет "кнопка" выбора города.
    На сомом деле это не кнопка, а карточка (отступы 5, закругление 20, возвышение 5, фон серый, содержимое белое),
    внутри неё - значок и текст в полностью центрированном (horizontalArrangement и verticalAlignment) ряду,
    к этому Row примените кликабельность (choose присвоить истину) и отступы на 25.

    Создайте BackHandler для возврата от выбора городов к главному экрану. Проверьте логику работы программы.
    Список городов должен редактироваться, кнопка "назад" работать. Затем переходите к функции ниже.
*/

                // Эта функция должна отобразить карточку текущей погоды в одном указанном городе
@Composable     // в функцию передаётся два параметра: наше погодное api и название города, который надо отобразить
private fun WeatherCity(api: WeatherApi, city: String) {
    Text(city)  // эту временную строку надо убрать, она была нужна, пока вы писали предыдущую функцию

}

/*
    В этой функции создайте продюсер, получающий погоду (внутренний класс Weather нашего интерфейса WeatherApi) в
    указанном в параметре city городе. По умолчанию, пока ответ сервера не пришёл, значение продюсера - null:
    val weather by produceState<WeatherApi.Weather?>(null) {
        value = api.weather(city)
    }

    Отобразите карточку (отступы и возвышение на 5, закругление на 20, цвет контента белый). Внутри неё в качестве фона
    поместите картинку из рисунка drawable.weather, установите режим заполнения: contentScale = ContentScale.Inside

    Поверх картинки (просто после неё в тексте программы) поместите столбец с отступами на 15. Внутри - название города
    полужирным текстом. Ниже - конструкция weather?.let{...} - элементы внутри этого блока будут отображаться только
    когда ответ сервера будет получен, и переменная weather не null. Обращаться к этой переменной внутри блока следует
    только через слово "it".

    Внутри блока - горизонтальный центрированный ряд с распределением элементов "промежутки внутри". В нём мы должны
    отобразить температуру (it.main.temp) и описание погоды ( it.weather - это список из нескольких описаний, например,
    "пасмурно", "снег", "гололёд". Мы отобразим только первое из списка: it.weather.first().description ).

    Чтобы отобразить температуру в корректном виде, создайте в начале функции объект-помощник:
    val decimal = remember { DecimalFormat("+#.# ℃;-#.# ℃") }
    то есть, будет отображаться не более одного знака после запятой, с обязательным знаком + или - в начале и ℃ в конце.
    Отображать температуру теперь можно функцией форматирования: decimal.format(it.main.temp). Размер шрифта 20.
 */