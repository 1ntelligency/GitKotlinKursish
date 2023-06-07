import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import ui.LazyColumn

//  Начиная с этого задания нам будет необходимо подключение к API сервера мастерской М4.
//  Вне мастерской эти задания выполнить и проверить не получится.

private interface CityApi {                             // интерфейс для связи с сервером REST API
    // класс для получения данных с сервера: сюда будут помещены тип и название населённого пункта
    data class City (val type: String?, val city: String)

    @GET("city") // Функция, производящая GET-запрос по адресу https://mad.lrmk.ru/kladr/city
    suspend fun cities(): List<City> // и получающая список городов из JSON типа [{ type : "г", city : "Лермонтов" }...]

    companion object { // построитель интерфейса для API сервера https://mad.lrmk.ru/kladr используя формат данных JSON
        fun getApi() = Retrofit.Builder()
            .baseUrl("https://mad.lrmk.ru/kladr/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create<CityApi>()
    }
}

@Composable
fun LessonCities() {

}

/*
    Создайте экземпляр нашего API. В Composable-функции это нужно сделать внутри remember:
    val api = remember { CityApi.getApi() }
    иначе экземпляр будет создаваться заново при каждой перерисовке пользовательского интерфейса.

    Создайте продюсер, который получит у нашего API список городов, отсортированный по алфавиту:
    val cities by produceState(emptyList()) {
        value = api.cities().sortedBy { it.city }
    }
    Примечание: emptyList() - начальное значение для cities, до ответа сервера список будет пустым.

    Создайте "ленивый" столбец для отображения элементов списка cities. Отступы текста - на 10.
*/