import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandIn
import androidx.compose.animation.shrinkOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntSize
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
import retrofit2.http.GET
import retrofit2.http.POST
import ui.BackHandler
import ui.verticalScrollHelper

private interface SendApi {
    @GET("users")
    suspend fun users(): List<User> // функция для получения списка зарегистрированных пользователей почтового сервиса

    data class User(                // ФИО, логин (почтовый адрес), должность и имя файла аватарки пользователя
        val surname: String, val firstname: String, val lastname: String,
        val login: String, val position: String, val avatar: String
    )

    // Создайте самостоятельно функцию отправки сообщения: метод POST, кодировка полей как в веб-форме, в функцию нужно
    // полями запроса передавать строковые параметры login, password, to (кому), title (тема) и message (само сообщение).
    // Функция возвращает структуру Result как в предыдущем задании. Адрес API - https://mad.lrmk.ru/mail/send

    companion object {
        fun getApi() = Retrofit.Builder()
            .baseUrl("https://mad.lrmk.ru/mail/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create<SendApi>()
    }
}

@Composable
fun LessonSend() {

}

/*
    Создайте экземпляр API и получите список пользователей users. Создайте также переменную to для хранения
    редактируемого списка таких пользователей, начальное значение - пустой РЕДАКТИРУЕМЫЙ список.

    Создайте две логических переменных: show (отобразить список пользователей) и sent (сообщение успешно отправлено),
    начальное значение - ложь.
    Создайте две пустых строковых переменных title и message для полей ввода.
    Создайте три реквестера фокуса (как в задании 50) для каждого из трёх полей формы.
    Создайте scope для запуска фоновых процессов.
    Оформите BackHandler, чтобы кнопка возврата сбрасывала переменную show (то есть, закрывала список пользователей).

    Разместите в столбце три поля ввода, как в образце. Первое поле, "кому", пока пусто ("") и ничего не делает ({}).
    Всем полям настройте надписи и реквестеры фокуса. Полю "кому" дополнительно добавьте модификатор
    onFocusChanged { show = it.isFocused } - когда поле получает фокус ввода, нужно отобразить список пользователей.

    Далее, заключите весь свой столбец внутрь Box, после столбца внутри этого же бокса поместите FloatingActionButton
    с выравниванием вниз-вправо и отступами на 15. Код нажатия этой кнопки напишем чуть позже.

    После кнопки, всё ещё внутри бокса, поместите AnimatedVisibility, управляемый переменной show. Выравнивание - центр,
    анимации - expandIn { IntSize.Zero } и shrinkOut { IntSize.Zero }. Внутри - ленивый столбец для отображений карточек
    пользователей (отступы 5, закругление/возвышение 10).

    Элемент Row внутри карточки должен быть нажимаемым: если текущий элемент входит в список пользователей "to" (пишется
    it in to), то исключить его из этого списка (to -= it), иначе включить его в этот список (to += it).

    Слева от имени пользователя выводится: Если он входит в список "to", то значок CheckCircle цвета secondaryVariant,
    иначе картинка-аватарка этого пользователя. И то и другое - с отступами на 5, размер 48. Аватарка - обрезана.
    Сведения о пользователе - в столбце с единым отступом на 5. Размер шрифта - 15. Цвет почтового адреса - серый.

    Теперь, первое поле ввода "кому" должно содержать список адресов выбранных пользователей. Получить его можно так:
    to.joinToString("; ") { соедините здесь ФИО и адрес пользователя, как в образце }
                    (^ через точку с запятой соединяется всё содержимое списка "to")

    Программируем нажатие плавающей кнопки. Делается три проверки: если какое-либо из полей ввода пусто (к переменным
    to, title и message примените условие .isEmpty()), то установить фокус в это поле ввода (focusXXX.requestFocus())
    Иначе запускаем фоновый процесс scope.launch{...}, в котором производим POST-запрос send на сервер. Список адресов
    to для этого запроса можно соединить так: to.joinToString(";") { "${it.login}@mad.lrmk.ru" }

    Нужно проверить результат этого запроса. Если success не равно 0, присвойте истину переменной sent. Самостоятельно
    сделайте так, чтобы при этом скрылись форма отправки и плавающая кнопка, но появилось сообщение об успехе отправки.
*/