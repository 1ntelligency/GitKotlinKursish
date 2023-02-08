import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.lessonsLogin
import data.lessonsPassword
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import ui.BackHandler

/*
    Создайте самостоятельно интерфейс AuthApi для доступа к API https://mad.lrmk.ru/mail/ и функцию POST-запроса
    login(login, password) с двумя параметрами-строками, являющимися ПОЛЯМИ POST-запроса. Способ кодирования данных -
    как в веб-форме (не JSON!). Функция возвращает объект класса Result, такого же, как в предыдущем уроке.
*/
private interface AuthApi

@Composable
fun LessonLogin() {

}


/*
    Задание очень похоже на предыдущее, меньше полей ввода, меньше проверок на ошибки ввода - оставьте только три первые
    проверки.

    Нижняя текстовая кнопка (Зарегистрироваться) работает следующим образом:
        Создайте в начале программы логическую переменную register, начальное значение - false, ниже напишите
        BackHandler для этой переменной, чтобы кнопка "назад" возвращала к форме авторизации.
        Ниже создайте объект AnimatedVisibility для переменной register. В качестве анимаций -  fadeIn() и fadeOut().
        Внутри этого блока просто вызовите функцию LessonRegistration(), которую вы написали в предыдущем уроке.

        Столбец со всеми элементами текущей формы находится в другом AnimatedVisibility, активном когда переменная
        register НЕ истинна. Ещё вам потребуется третий AnimatedVisibility, как в прошлом уроке, который появляется в
        случае успешной авторизации.

    И ещё - в случае успеха, внутри блока api.login(login, pass).let { ... }, когда success истинна, произведите два
    присваивания: lessonsLogin = login и lessonsPassword = pass - это две встроенные переменные нашего задачника, они
    пригодятся нам, чтобы делать следующие задания (в них потребуется предварительная авторизация пользователя).
*/