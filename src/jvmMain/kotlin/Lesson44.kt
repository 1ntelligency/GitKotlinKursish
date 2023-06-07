import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import ui.LazyColumn
import ui.LazyVerticalGrid

private interface AlphaApi {
    // На этот раз сами, с нуля напишите этот интерфейс с базовым адресом API https://mad.lrmk.ru/kladr/
    // и GET-запросом к его странице city, возвращающим список городов (в классе данных City только одна строка city)
}

@Composable
fun LessonAlphaPages() {

}

/*
    Как и ранее, создайте экземпляр нашего API и продюсер, который получает список городов.
    Теперь создадим список, состоящий только из первых букв этих городов, причём они будут сгруппированы, то есть,
    не будут повторяться:
    val letters by remember { derivedStateOf {
        cities.groupBy { it.city.first().toString() }.map { it.key }
    } }
    сначала идёт группировка по первой букве, вторая операция, map, отбрасывает из результата всё лишнее, кроме ключа,
    который и есть начальная буква группы городов.

    Далее создайте строковую изменяемую переменную letter, начальное значение - русская буква "А".
    Теперь, связкой remember / derivedStateOf создайте отфильтрованный список городов list, содержащий только города на
    букву из переменной letter. Используйте для этого такую функцию: cities.filter { it.city.startsWith(letter) }

    Далее идёт обычный столбец из двух элементов, отделённых друг от друга разделителем.

    Первый - "ленивый" столбец с весом 1, отображающий отфильтрованный список городов с разделителями и отступами на 10.

    Второй - "ленивая" вертикальная сетка, настройка ширины столбцов - GridCells.Adaptive(36.dp). В этой сетке
    отобразите буквы из списка letters. Каждый элемент - IconButton (это даёт только визуальный "круглый" эффект
    нажатия и не обязывает отображать именно значок). В кнопке - текст, сама буква с размером шрифта 18.
    По нажатию кнопка присваивает соответствующую букву переменной letter. Чтобы уже выбранная буква не была активной,
    добавьте в саму кнопку второй параметр, enabled = letter != it

    Чтобы при выборе буквы позиция прокрутки в списке автоматически сбрасывалась на начало, можно до начала или после
    окончания столбца применить к state ленивого списка (его надо объявить и использовать отдельно) прокрутку на начало:
    LaunchedEffect(letter) { state.scrollToItem(0) }
    при любом изменении переменной letter список со статусом state будет автоматически прокручиваться на 0 элемент.
 */