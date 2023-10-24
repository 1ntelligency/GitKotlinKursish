import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LessonScaffold(exit: ()->Unit) {

}

/*
    Используйте элемент Scaffold (строительные леса́) для создания полной разметки окна:
    Scaffold(параметры) { внутреннее содержимое экрана }
    Параметры:
        topBar = { Возьмите из задания №33. Можно просто вызвать здесь функцию этого урока }
        bottomBar = { Возьмите из задания №34. Можно просто вызвать здесь функцию этого урока }
        floatingActionButton = { Возьмите из задания №31. Можно просто вызвать функцию этого урока }
    Блок {} внутреннего содержимого включает текст. Для текста обязательно примените
        модификатор отступа с параметром it, который автоматически передаётся в этот блок из Scaffold.
        Это делается для того, чтобы внутреннее содержимое "знало", какие области экрана уже заняты панелями.
*/