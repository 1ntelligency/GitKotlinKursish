import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
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
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.*

private interface RegApi {

    @POST("register")  // запросы, которые что-либо меняют на сервере, обычно оформляются как POST-запросы
    suspend fun register(@Body user: User): Result
    // @Body означает, что содержимое объекта user будет преобразовано в JSON и отправлено в запросе на сервер.

    data class User(      // сюда нужно будет поместить всю информацию о пользователе для отправки на сервер
        val login: String, val password: String,
        val surname: String, val firstname: String, val lastname: String, val position: String
    )

    // Результат запроса, возвращаемый сервером. Если строка error не null, произошла ошибка подключения или сервера.
    // Если success == 0, это означает негативный ответ сервера, success > 0 означает успешную регистрацию на сервере:
    data class Result(val success: Int, val error: String?)

    companion object {
        fun getApi() = Retrofit.Builder()
            .baseUrl("https://mad.lrmk.ru/mail/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create<RegApi>()
    }
}

@Composable
fun LessonRegistration() {

}

/*
    Ваша программа должна самостоятельно обрабатывать большинство ошибок пользователя:
        "Имя пользователя не может быть пустым" (логин),
        "Допускаются только строчные латинские буквы, цифры и точки" (в логине),
        "Пароль не может быть менее 6 символов",
        "Пароль должен содержать буквы и цифры",
        "Пароли не совпадают",
        "Введите фамилию",
        "Введите имя",
    и только, если все введённые данные соответствуют этим правилам, запрос отправляется. Если же при этом ошибку
    возвращает сам сервер, или система говорит об отсутствии соединения, то программа должна отобразить и это сообщение.

    Создайте экземпляр API и переменную scope для создания фоновых потоков - они нужны для отправки запросов.
    Создайте по текстовой переменной на каждое поле ввода, и одну, error - под текстовую надпись об ошибке пользователя.
    Создайте по одному реквестеру фокуса для каждого поля ввода (кроме двух последних), пример:
        val focusLogin = remember { FocusRequester() }
    они используются когда программе надо принудительно установить фокус в определённый пользовательский элемент.
    Создайте по одной переменной (например, errorLogin) логического типа (по умолчанию false) на каждое поле ввода
        (кроме двух последних), они будут использоваться для визуального привлечения внимания к ошибочной строке ввода.
    И ещё 2 логические переменные: success (регистрация успешна) и showPass (отображать символы пароля на экране).

    В центрированном столбце отобразите заголовок основным цветом темы, размер шрифта 20, отступы на 4.

    Все поля ввода идут с отступами на 4, на всю ширину экрана.
    К каждому нужно также применить модификатор .focusRequester(focusLogin) - для каждого укажите свой реквестер, они
        будут использованы для принудительной установки фокуса.
    Все поля однострочные и имеют форму CircleShape.
    К каждому применяется параметр isError = errorLogin (для каждого указать свой) - при установке в true они будут
        автоматически окрашивать поле ввода в красный цвет, привлекая внимание пользователя.
    У всех есть label, и у некоторых - placeholder и trailingIcon (причём здесь необязательно должен быть значок,
        например, у логина в trailingIcon надпись с отступами на 10, а у паролей - IconToggleButton).

    Для паролей указывается визуальная трансформация:
        если showPass истинна (символы видимы), то VisualTransformation.None, иначе PasswordVisualTransformation()
    Второе поле ввода пароля отображается внутри AnimatedVisibility, в качестве визуальных эффектов можно использовать
        enter = expandVertically { 0 }, exit = shrinkVertically { 0 }

    У разделителей и кнопок тоже отступы на 4.
    Кнопка высотой строго 72dp, на всю ширину, круглая форма. У надписи внутри кнопки отступы на 10.

    Ниже кнопки - текст, отображающий строку error. Если всё нормально, эта строка пуста и не видна на экране.
    Цвет надписи - MaterialTheme.colors.error, текстовое выравнивание по центру (пригодится, если сообщение длинное).

    Теперь, наконец, к действию, которое производит кнопка. Она запускает фоновый процесс scope.launch {...}, в котором
        нужно проверить ввод пользователя на все возможные ошибки (см. выше) и обратить на них его внимание, либо,
        если всё в порядке, отправить запрос на сервер и дождаться его ответа.

    Пример начала проверок:
        if (login.isEmpty()) {                                  // если строка login пуста,
            focusLogin.requestFocus()                           // принудительно фокусируемся на поле ввода логина,
            error = "Имя пользователя не может быть пустым"     // выводим сообщение об ошибке,
            errorLogin = true                                   // отмечаем поле ввода красным.
        }
        else if (...                                            // остальные проверки - самостоятельно...

    Подсказки:
    Проверка, что в логине не только латинские буквы, цифры и точки: login.any { it !in ('a'..'z') + ('0'..'9') + '.' }
    Проверка, что пароль1 пуст или состоит из менее 6 символов: pass1.length < 6
    Проверка, что в пароле1 нет ни одной буквы или цифры: pass1.none { it.isLetter() } || pass1.none { it.isDigit() }
    Проверка, что пароли не совпадают, производится только в режиме скрытия символов пароля: !showPass && pass2 != pass1

    В самом конце всех проверок, идущих цепочкой if () ... else if () ... else if () ... последним блоком идёт блок
    try ... catch, который позволяет обработать все возможные ошибки интернета или сервера:
        else try {
            val user = RegApi.User(login, pass1, surname, firstName, lastName, position)        // подготовка данных
            api.register(user).let {            // отправка запроса на сервер, и, если ответ пришёл, то:
                error = it.error ?: ""          // если error не null, показать это сообщение об ошибке, иначе пусто,
                success = it.success > 0        // успех в случае, если сервер вернул значение success больше нуля.
            }
        } catch (_: Exception) { error = "Кажется, сервер не отвечает 😥" }                     // если ответа нет

    В случае успешной регистрации:
    В начале основного Column создайте объект AnimatedVisibility, зависящий от переменной success, в качестве анимации
    входа можно использовать expandVertically { 0 }. Внутри - Box, растянутый на весь экран. В центре Box - сообщение
    об успешной регистрации (шрифт 20, основной цвет темы).
*/