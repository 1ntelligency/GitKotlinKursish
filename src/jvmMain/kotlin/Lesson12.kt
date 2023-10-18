import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable    // Используйте exit в качестве параметра-действия для кнопки выхода
fun LessonRegForm(exit: ()->Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var login by remember { mutableStateOf("") }
        var pass by remember { mutableStateOf("") }
        var gender by remember { mutableStateOf(0) }
        var rules by remember { mutableStateOf(false) }
        Text("Регистрация пользователя", fontSize = 20.sp)
        OutlinedTextField(login, { login = it }, Modifier.padding(4.dp),
            placeholder = { Text("Введите логин") },
            label = { Text("Имя пользователя") },
            singleLine = true
        )
        OutlinedTextField(pass, { pass = it }, Modifier.padding(4.dp),
            placeholder = { Text("Введите не менее 6 букв и цифр") },
            label = { Text("Пароль") },
            visualTransformation = PasswordVisualTransformation(),
            singleLine = true
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Вы:")
            RadioButton(gender == 1, { gender = 1 })
            Text("мужчина", Modifier.clickable { gender = 1 })
            RadioButton(gender == 2, { gender = 2 })
            Text("женщина", Modifier.clickable { gender = 2 })
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(rules, { rules = it })
            Text("с правилами ознакомлен" + if (gender==2) "а" else "  ", Modifier.clickable { rules = !rules })
        }
        Button({}) {
            Icon(Icons.Default.Check, null)
            Text("Зарегистрироваться")
        }
        TextButton(exit) { Text("Выход") }
    }
}

/*
    Пришло время проверить свои знания и умения. Создайте форму регистрации (пока не рабочую, только дизайн).

    Ключевые слова для напоминания: четыре переменные, столбец с горизонтальным выравниванием, размер шрифта (20),
    поля ввода, модификаторы отступа (на 4), горизонтальные ряды, радиокнопки, кнопка, текстовая кнопка...

    Переменную "пол" можно сделать, например, числовой, где 1=мужчина, 2=женщина, 0=не выбран.
    На кнопке регистрации - значок Icons.Default.Check

    После "с правилами ознакомлен" в случае мужского пола выводится пробел, в случае женского - буква "а"
*/