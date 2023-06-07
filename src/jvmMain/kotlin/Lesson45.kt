import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ui.LazyColumn
import ui.LazyRow
import java.text.DecimalFormat

/*
    На этот раз реализация интерфейса PagesApi - полностью на вас. Базовый адрес сервера - https://mad.lrmk.ru/price/
    GET-запрос price(offset, count) должен обращаться по адресу вида https://mad.lrmk.ru/price/offset/count
    где count - количество возвращаемых элементов, а offset - смещение от начала списка. Возвращается список
    из элементов Price, состоящих из строки name и вещественного (Float) числа cost
*/

@Composable
fun LessonNumberPages() {

}

/*
    Как и ранее, создайте экземпляр нашего API. Получать данные мы на этот раз будем постранично, по 10 элементов.
    Создайте целую изменяемую переменную page, начальное значение 0. Продюсер списка будет зависеть от этой переменной,
    как от ключа, и при каждом её изменении новые данные будут запрашиваться с сервера автоматически:
    val price by produceState(emptyList(), page) {
        value = api.price(page*10, 10).toList()
    }

    Как и в предыдущем задании, далее идёт столбец из двух элементов, отделённых друг от друга разделителем. Первый -
    прайс-лист, в точности как в задании 43, только без фильтрации, в нашем списке не более 10 элементов.

    Вторым идёт "ленивый" горизонтальный ряд. Он не будет брать данные из какого-либо списка, а генерировать номера
    страниц автоматически. Задайте список элементов конструкцией items(page+10) {...} - в списке всегда будет на 10
    элементов больше, чем номер текущей страницы.
    Каждый элемент отображает текстовую кнопку размером 42.dp, на ней надпись = номерСтраницы+1, размер шрифта 18.
    Кнопка должна присваивать переменной page нужный номер страницы. Укажите также свойство enabled, чтобы кнопка
    текущей страницы не была активной.
 */