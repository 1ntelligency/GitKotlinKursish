import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun LessonCompass() {
    Box {
        Text("северо-запад", Modifier.align(Alignment.TopStart))
        Text("север", Modifier.align(Alignment.TopCenter), fontSize = 24.sp)
        Text("северо-восток", Modifier.align(Alignment.TopEnd))
        Text("запад", Modifier.align(Alignment.CenterStart), fontSize = 24.sp)
        Text("центр", Modifier.align(Alignment.Center), fontSize = 32.sp)
        Text("восток", Modifier.align(Alignment.CenterEnd), fontSize = 24.sp)
        Text("юго-запад", Modifier.align(Alignment.BottomStart))
        Text("юг", Modifier.align(Alignment.BottomCenter), fontSize = 24.sp)
        Text("юго-восток", Modifier.align(Alignment.BottomEnd))

    }
}

/*
    Создайте «коробку» - Box,
    в фигурных скобках1 - девять текстовых элементов - Text:
    где первый параметр в круглых скобках - надпись в кавычках,
    второй - модификатор выравнивания - Modifier.align(Alignment...)
    третий (не у всех) - размер шрифта: fontSize = 24.sp или fontSize = 32.sp у центральной надписи

    Справка:
    https://metanit.com/kotlin/jetpack/2.1.php
    https://metanit.com/kotlin/jetpack/4.1.php
 */