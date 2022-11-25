import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import data.userName
import kotlinx.coroutines.launch

@Composable
fun LessonSnackbar()  {

}

/*
    Создайте 2 переменные, область выполнения программ и состояние для Scaffold:
    val scope = rememberCoroutineScope()
    val state = rememberScaffoldState()

    Создайте Scaffold с параметрами:
        scaffoldState = state,
        floatingActionButton со значком ♥, которая будет запускать такое действие:
            scope.launch {
                state.snackbarHostState.showSnackbar("$userName, вы супер!", "Закрыть")
            }
*/