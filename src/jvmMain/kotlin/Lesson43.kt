import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import lessons.ModelAddressApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ui.LazyColumn
import java.text.DecimalFormat

private interface PriceApi {
    // Функция обращается по адресу вида https://mad.lrmk.ru/price/XXX/NNN, где NNN - количество возвращаемых элементов
    // списка, а XXX - смещение от начала списка, то есть, price/20/10 - отобразить элементы с 20 по 29.
    // Обратите внимание, как в этом случае строится описание функции:
    @GET("{offset}/{count}")
    suspend fun price(@Path("offset") offset: Int = 0, @Path("count") count: Int = 100): List<Price>
    // Заметьте, что для обоих параметров заданы значения по умолчанию, ток что, если вызвать эту функцию
    // без параметров, price(), то она вернёт 100 элементов начиная с 0, то есть с самого начала списка.

    class Price // сами создайте в этом классе 2 поля, имя и цену: строку name и вещественное (Float) число cost.

    // companion object с функцией getApi() в этот раз создайте сами. Базовый адрес сервера - https://mad.lrmk.ru/price/
}

@Composable
fun LessonSearchPrice() {

}

/*
    Создайте экземпляр нашего API (помните remember!). Создайте продюсер, который получит у нашего API прайс-лист
    (переменная price). Создайте изменяемую строковую переменную search для текстового поля ввода, через которое
    пользователь будет осуществлять поиск.

    Теперь - самое главное. Мы создадим новый список, list, в который будут попадать только элементы, соответствующие
    строке поиска. По правилам Compose зависимые данные оформляются через блок remember { derivedStateOf { ... } }:
    val list by remember { derivedStateOf {
        price.filter { search in it.name }
    } }
    При ЛЮБОМ изменении переменной search (ввод пользователя) список list будет АВТОМАТИЧЕСКИ перестроен.

    Далее, в "ленивом" столбце отобразите через item{} первый элемент, в который поместите текстовое поле для ввода
    строки поиска. Отступы на 8, в одну строку, есть label и trailingIcon. На значок ✖ через clickable назначьте очистку
    поиска.

    Ниже отобразите все элементы отфильтрованного списка list. Каждый - в горизонтальном ряду с отступами на 8,
    выравнивание - по нижней границе. Ряды визуально отделяются разделителями.

    Внутри ряда - описание товара с весом 1 и одним отступом справа на 8. Потом - цена, без веса, поэтому сдвигается к
    правой стороне экрана. Для отображения цены в корректном виде создайте в начале функции объект-помощник:
    val money = remember { DecimalFormat(",##0.00 ₽") }
    Это означает: ровно два десятичных знака (копейки), не менее одной цифры в целой части, при этом отделяются
    разделителем (в РФ запятая автоматически меняется на пробел) на группы по три цифры. В конце - знак рубля ₽.

    Отображать цену теперь можно функцией форматирования: money.format(it.cost)
 */