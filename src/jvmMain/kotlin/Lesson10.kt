import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun LessonTextFields() {
    var textfieldvalue1 by remember { mutableStateOf("") }
    var textfieldvalue2 by remember { mutableStateOf("") }
    var textfieldvalue3 by remember { mutableStateOf("") }
    var textfieldvalue4 by remember { mutableStateOf("") }

    Column() {
        TextField(
            textfieldvalue1,
            { textfieldvalue1 = it },
            label = { Text("Поле ввода") },
            modifier = Modifier.fillMaxWidth().padding(10.dp)
        )
        OutlinedTextField(
            textfieldvalue2,
            { textfieldvalue2 = it },
            label = { Text("Поле ввода с окантовкой") },
            modifier = Modifier.fillMaxWidth().padding(10.dp)
        )
        BasicTextField(
            textfieldvalue3,
            { textfieldvalue3 = it },
            Modifier.fillMaxWidth().padding(10.dp)
        )

        TextField(
            textfieldvalue4,
            { textfieldvalue4 = it },
            label = { Text("Ввод текста") },
            modifier = Modifier.fillMaxSize().padding(10.dp)
        )
    }

}




/*
    Тема - ввод текста.
    Создайте через связку remember / mutableStateOf четыре текстовые ("") переменные - по одной для каждого поля ввода.
    Создайте столбец, а внутри - текстовые поля: TextField, OutlinedTextField, BasicTextField
    Все работают одинаково: TextField(переменная, { переменная = it })

    Всем придайте модификаторы: отступы на 10 и заполнение всей возможной ширины fillMaxWidth()
    Последний элемент такой же, как первый, но вместо fillMaxWidth() сделайте заполнение всей площади fillMaxSize()

    Всем (кроме BasicTextField) задайте параметр "надпись", например: label = { Text("Поле ввода") }

    Справка:
    https://metanit.com/kotlin/jetpack/4.3.php
*/