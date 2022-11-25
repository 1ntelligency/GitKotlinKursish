import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable // Используйте exit в качестве параметра-действия для пункта "выход"
fun LessonMenu(exit: ()->Unit) = Box(Modifier.fillMaxSize()) {

}

/*
    Тема урока - выпадающее меню. Для работы вам нужна логическая переменная, начальное значение - false
    Кнопка, вызывающая меню, должна быть в одной "коробке" с самим меню, поэтому:
    Создайте Box без параметров, а внутри него:
        Кнопку, которая присваивает переменной истину (true);
        Элемент DropdownMenu, где:
            первый параметр - сама переменная;
            второй - действие, когда пользователь щёлкает мимо меню (нужно присвоить переменной ложь);
            последний - блок {}, в котором находятся элементы меню:
                Каждый элемент - это DropdownMenuItem,
                    первый параметр - действие по его нажатию (пока просто присвоим ложь для закрытия меню);
                    второй - блок {}, состоящий из значка Icon и текстового элемента с отступом на 6.

    Используйте значки: Icons.Default.Create, Icons.Default.Share, Icons.Default.ExitToApp;
    Используйте разделитель Divider() перед последним элементом;
    Используйте exit в качестве параметра-действия для пункта "выход".
    Чтобы задание успешно проверилось, задайте самому меню третий параметр - focusable = false,
        тогда оно не будет закрываться при нажатии на кнопку проверки.

    Справка:
    https://metanit.com/kotlin/jetpack/4.17.php
*/