import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ui.BackHandler

@Composable
fun LessonBack() {
    var file: String? by remember { mutableStateOf(null) }
    BackHandler(file != null) { file = null }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Используйте кнопку возврата на устройстве",
            modifier = Modifier.padding(4.dp)
        )
        file?.let { Image(painter = painterResource(it), "") } ?: Row(modifier = Modifier.fillMaxWidth()) {
            ElevatedButton(
                onClick = { file = R.drawable.p1 },
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .padding(3.dp)
            ) {
                Image(painter = painterResource(R.drawable.p1), contentDescription = "Яблоко")
            }

            ElevatedButton(
                onClick = { file = R.drawable.p2 },
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .padding(3.dp)
            ) {
                Image(painter = painterResource(R.drawable.p2), contentDescription = "Груша")
            }
            ElevatedButton(
                onClick = { file = R.drawable.p3 },
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .padding(3.dp)
            )
                {
                    Image(painter = painterResource(R.drawable.p3), contentDescription = "Вишня")
                }
            }
        }
    }

/*
    Создайте текстовую переменную file, по умолчанию равную null (то есть, ничто, отсутствие какого-либо значения):
    var file: String? by remember { mutableStateOf(null) }
    Обратите внимание, что здесь мы явно указали тип данных как "строка текста", которая может быть null (знак ?)

    Содержимое будет внутри центрированного столбца, сначала идёт текст заголовка с отступами на 4

    Ниже поместите конструкцию file?.let { блок1 } ?: блок2
    блок1 отображается если file не null,
        поместите сюда Image, отображающий painterResource от параметра it - он равен строке file, но уже точно не null;
    блок2 отображается если file == null,
        поместите сюда горизонтальный ряд, внутри которого - 3 кнопки, как в задании №6.
    Разбивайте всю эту конструкцию на несколько строк по необходимости

    Суть этого задания - в слежении за аппаратной кнопкой (или жестом) "возврата" устройства.
    По её нажатии пользователь будет возвращаться к выбору из 3 картинок.
    Для этого напишите выше или ниже основной конструкции команду обработки:
    BackHandler(file != null) { file = null }
    то есть, если file чем-то заполнен, то есть, пользователь сделал выбор, кнопка возврата делает откат к null;
    в противном случае кнопка работает, как обычно - закрывает приложение.
*/