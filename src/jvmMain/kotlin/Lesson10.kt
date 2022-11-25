import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LessonTextFields() {

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