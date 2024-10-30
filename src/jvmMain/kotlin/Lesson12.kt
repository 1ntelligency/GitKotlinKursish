import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
fun LessonRegForm(exit: ()->Unit){
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf(0) }
    var rules by remember { mutableStateOf(false) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Регистрация пользователя", fontSize = 20.sp);
        OutlinedTextField(
            login, { login = it },
            label = { Text("Имя пользователя") },
            modifier = Modifier.padding(4.dp),
            placeholder = { Text("Введите логин") }
        )
        OutlinedTextField(
            password,
            { password = it },
            label = { Text("Пароль") },
            modifier = Modifier.padding(4.dp),
            placeholder = { Text("Введите не менее 6 букв и цифр") },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation()
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Вы:")
            RadioButton(
                gender == 1,
                { gender = 1 })
            Text("мужчина", Modifier.clickable { gender = 1 })
            RadioButton(
                gender == 2,
                {gender = 2})
            Text("женщина", Modifier.clickable { gender = 2 })
        }
        Row (verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.offset(x = (-4.dp))) {
            Checkbox( rules,
                {rules = !rules}
                )
            Text("с правилами ознакомлен", Modifier.clickable { rules = !rules })
            if (gender == 2) Text("а")
        }
        Button({}) {
            Icon(Icons.Default.Check, "")
            Text("Зарегистрироваться")
        }
        TextButton(onClick = {exit()}) {
            Text("Выход")
        }

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