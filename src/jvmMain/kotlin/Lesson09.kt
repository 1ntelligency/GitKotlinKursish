import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LessonChecks() {
    Column {
        var red by remember { mutableStateOf(true) }
        var yellow by remember { mutableStateOf(true) }
        var green by remember { mutableStateOf(false) }
        Row(Modifier.clickable { red = !red }, verticalAlignment = Alignment.CenterVertically) {
            Checkbox(red, {red = !red})
            Text("Красный")
        }
        Row(Modifier.clickable { yellow = !yellow }, verticalAlignment = Alignment.CenterVertically) {
            Checkbox(yellow, {yellow = !yellow})
            Text("Жёлтый")
        }
        Row(Modifier.clickable { green = !green }, verticalAlignment = Alignment.CenterVertically) {
            Checkbox(green, {green = !green})
            Text("Зелёный")
        }
        Column(Modifier.clip(CircleShape).background(Color.Gray)) {
            Box(
                Modifier.weight(1f).padding(16.dp).aspectRatio(1f).clip(CircleShape).background(
                if (red) Color.Red else Color.DarkGray
            ))
            Box(
                Modifier.weight(1f).padding(16.dp).aspectRatio(1f).clip(CircleShape).background(
                if (yellow) Color.Yellow else Color.DarkGray
            ))
            Box(
                Modifier.weight(1f).padding(16.dp).aspectRatio(1f).clip(CircleShape).background(
                if (green) Color.Green else Color.DarkGray
            ))
        }
    }
}

/*
    Тема - переключатели
    Всё как в предыдущем задании,
    только вместо одной переменной color создайте 3 логические (true/false) переменные red, yellow, green
    И вместо радиокнопок - чекбоксы.

    Справка:
    https://metanit.com/kotlin/jetpack/4.4.php
*/