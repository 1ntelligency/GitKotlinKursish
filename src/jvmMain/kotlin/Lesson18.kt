import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LessonPadding(colors: List<Pair<String, Color>>) {
        Column {
            colors.forEach { (name, color) ->
                Text(
                    text = name,
                    color = color,
                    modifier = Modifier.padding(8.dp))
                Divider()
            }
        }
    }

/*
    Это почти повтор предыдущего задания. Чтобы список выглядел красивее и лучше читался,
    придайте каждому элементу модификатор отступа на 8, а также добавьте в блок цикла разделитель - Divider()
*/