import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import data.userName
import kotlinx.coroutines.launch

@Composable
fun LessonSnackbar()  {

}

/*
    Создайте 2 переменные, область выполнения программ и состояние для Snackbar (элемента для показа сообщений):
    val scope = rememberCoroutineScope()
    val state = remember { SnackbarHostState() }

    Создайте Scaffold с параметрами:
        snackbarHost = { SnackbarHost(state) },
        floatingActionButton = { FloatingActionButton({...}){...} }
        - кнопку со значком ♥, которая будет по нажатию запускать (launch) в отдельном потоке (scope) такое действие:
            scope.launch {
                state.showSnackbar("$userName, вы супер!", "Закрыть")
            }
*/