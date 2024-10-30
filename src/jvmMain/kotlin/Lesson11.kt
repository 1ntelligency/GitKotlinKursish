import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun LessonTextFieldTypes() {
    var textfieldvalue1 by remember { mutableStateOf("") }
    var textfieldvalue2 by remember { mutableStateOf("") }
    var textfieldvalue3 by remember { mutableStateOf("") }
    var textfieldvalue4 by remember { mutableStateOf("") }

    Column() {
        OutlinedTextField(
            textfieldvalue1,
            { textfieldvalue1 = it },
            label = { Text("Поле ввода пароля") },
            modifier = Modifier.fillMaxWidth().padding(10.dp),
            placeholder = { Text("Введите не менее 6 букв и цифр") },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation()
        )
        OutlinedTextField(
            textfieldvalue2,
            { textfieldvalue2 = it },
            label = {
                Row (verticalAlignment = Alignment.CenterVertically){
                    Icon(Icons.Default.Edit, "")
                    Text("Поле с кнопками")
                }
                    },
            modifier = Modifier.fillMaxWidth().padding(10.dp),
            placeholder = { Text("Начинайте ввод...") },
            singleLine = true,
            leadingIcon = {
                Icon(
                    Icons.Default.Clear, "",
                    tint = Color.Red,
                    modifier = Modifier.clickable{})
            },
            trailingIcon = {
                Icon(Icons.Default.Search, "",
                    tint = (MaterialTheme.colorScheme.primary),
                    modifier = Modifier.clickable{})
            }
        )
        OutlinedTextField(
            textfieldvalue3,
            { textfieldvalue3 = it },
            label = { Text("Закруглённое поле ввода") },
            modifier = Modifier.fillMaxWidth().padding(10.dp),
            singleLine = true,
            shape = CircleShape,
        )

        OutlinedTextField(
            textfieldvalue4,
            { textfieldvalue4 = it },
            label = { Text("Что за фрукт?") },
            modifier = Modifier.padding(10.dp),
            leadingIcon = {
                Image(painterResource(R.drawable.p1), "",
                    modifier = Modifier.padding(4.dp),
                    alignment = Alignment.TopStart
                )
            }
        )
    }

}




/*
    Тема - дополнительные возможности ввода текста.
    Сделайте всё, как в предыдущем задании, только все четыре элемента будут OutlinedTextField.

    Первым двум задайте параметр "текст подсказки", например: placeholder = { Text("Введите не менее 6 букв и цифр") }
    и параметр "одна строка", чтобы в них нельзя было разбивать строку кнопкой Enter: singleLine = true

    Первое поле - для ввода пароля, оно должно скрывать символы при вводе.
    Задайте ему параметр визуальной трансформации: visualTransformation = PasswordVisualTransformation()

    "Округлите" третье поле ввода, придав ему параметр shape = CircleShape

    Второе поле мы украсим значками. Для этого есть два параметра: leadingIcon и trailingIcon - значки слева и справа
    внутри {скобок} этих двух параметров можно указать значки Icon: Icons.Default.Clear и Icons.Default.Search
        * укажите их цвет (tint), первому - красный, второму - основной цвет темы (MaterialTheme.colors.primary)
        * можете также указать модификатор нажатия clickable с пустым блоком {} чтобы значки визуально "нажимались"
    Параметр label второго поля ввода тоже будет чуть сложнее, чем обычно. Поместите в него горизонтальный ряд
        с вертикальным выравниванием по центру, а внутри - значок Icons.Default.Edit и текстовая надпись

    Вместо значка никто не запрещает использовать целую картинку: укажите в параметре leadingIcon четвёртого поля ввода
        элемент Image, отображающий с помощью функции painterResource изображение из ресурса R.drawable.p1 (отступы 4)

    Справка:
    https://metanit.com/kotlin/jetpack/4.3.php
*/