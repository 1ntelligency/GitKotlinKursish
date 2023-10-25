import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query
import ui.BackHandler
import ui.LazyColumn

private interface RegionCityApi { // интерфейс для связи с сервером REST API
    // классы для получения данных с сервера:
    data class City (val type: String?, val city: String)
    data class Region(val kladr_id: Long, val name_with_type: String)

    // Функция, производящая GET-запрос с параметром по адресу https://mad.lrmk.ru/kladr/city?region_id=XXXXX, где
    // ХХХХХ - код региона (region), как длинное целое (Long) число, причём код может быть null (Long?)
    // если код указан, возвращаются только города этого региона, если он null, возвращаются все города.
    @GET("city")
    suspend fun cities(@Query("region_id") region: Long?): List<City>

    // Самостоятельно опишите функцию regions(), производящую GET-запрос по адресу https://mad.lrmk.ru/kladr/region
    // и возвращающую список регионов, используя класс Region (как в предыдущем задании)

    companion object { // построитель интерфейса для API сервера https://mad.lrmk.ru/kladr используя формат данных JSON
        fun getApi(): RegionCityApi = Retrofit.Builder()
            .baseUrl("https://mad.lrmk.ru/kladr/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create()
    }
}

@Composable
fun LessonRegionCities() {

}

/*
    Создайте экземпляр нашего API (помните remember!). Создайте продюсер, который получит у нашего API список регионов.

    Объявите переменную region типа Long?, по умолчанию равную null:
    var region: Long? by remember { mutableStateOf(null) }

    Второй продюсер будет получать список городов в зависимости от значения переменной region:
    val cities by produceState(emptyList(), region) {
        value = api.cities(region).sortedBy { it.city }
    }
    Так как мы указали region вторым параметром (ключом) в продюсере, список будет автоматически запрашиваться при
    каждом изменении этой переменной. На этом с управлением данными мы закончили, осталось отображение.

    Сначала попробуйте вариант без анимации. Переменная region будет управлять тем, какой список будет показан:
    if (region == null)
        здесь "ленивый" столбец для отображения элементов списка regions, как в уроке 40
    else
        здесь "ленивый" столбец для отображения элементов списка cities, как в уроке 39

    В столбце регионов каждый элемент оформите как Row с вертикальным центрированием, чтобы отобразить помимо
    текста Icon со значком стрелочки.
    Сам Row сделайте clickable, при нажатии переменной region нужно присвоить значение kladr_id нажатого элемента.

    В список городов добавьте первым элементом одиночный item{...}, в котором укажите аналогичный clickable Row со
    стрелочкой назад. По его нажатию переменной region должен присваиваться null.

    Запрограммируйте BackHandler, чтобы кнопка телефона "назад" тоже обнуляла код региона.

    Чтобы позиция прокрутки первого списка не сбрасывалась при возврате, объявите в начале переменную
    val state = rememberLazyListState() и задайте её как параметр state только в первом LazyColumn

    Теперь программа должна быть полностью функциональной.

    --- АНИМАЦИЯ ---

    Для более плавного перехода между списками попробуем вместо конструкции if...else использовать анимацию.
    Конструкция в самом простом виде будет выглядеть так:

    AnimatedVisibility(region == null) {
        здесь "ленивый" столбец для отображения элементов списка regions
    }
    AnimatedVisibility(region != null) {
        здесь "ленивый" столбец для отображения элементов списка cities
    }

    Попробуйте приложение в этом варианте. Анимация по умолчанию может не совсем подходить под ваш дизайн.
    Попробуем вместо неё использовать анимацию горизонтального сдвига.
    Для этого внутрь каждого элемента AnimatedVisibility добавьте ещё два параметра:
    , enter = slideInHorizontally { it }, exit = slideOutHorizontally { it }
    Первый отвечает за анимацию входа, второй - выхода. Обе анимации - горизонтальный сдвиг (slide)
    В первом AnimatedVisibility перед обоими it поставьте знак минуса, чтобы сдвиг пошёл в другом направлении.
 */