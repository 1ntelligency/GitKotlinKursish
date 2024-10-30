import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LessonChecks() {
    var red by remember { mutableStateOf(true) }
    var yellow by remember { mutableStateOf(true) }
    var green by remember { mutableStateOf(false) }


    Column() {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable {
                    red = !red
                }
            ) {
                Checkbox(red, {
                    red = !red
                })
                Text("Красный")
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable {
                    yellow = !yellow
                }
            ) {
                Checkbox(yellow, {
                    yellow = !yellow
                })
                Text("Жёлтый")
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable {
                    green = !green
                }
            ) {
                Checkbox(green, {
                    green = !green
                })
                Text("Зелёный")
            }
        }

        Column(
            modifier = Modifier
                .width(192.dp)
                .clip(CircleShape)
                .background(Color.Gray)
                .padding(vertical = 0.dp)
                .padding(horizontal = 16.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .clip(CircleShape)
                    .background(if (red) Color.Red else Color.DarkGray)
                    .padding(16.dp)
            )
            Box(
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .clip(CircleShape)
                    .background(if (yellow) Color.Yellow else Color.DarkGray)
                    .padding(16.dp)
            )
            Box(
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .clip(CircleShape)
                    .background(if (green) Color.Green else Color.DarkGray)
                    .padding(16.dp)
            )
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