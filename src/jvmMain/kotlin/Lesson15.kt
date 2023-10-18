import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.*
import ui.DropdownMenu

@Composable // Используйте exit в качестве параметра-действия для пункта "выход"
fun LessonMenu(exit: ()->Unit) {

}

/*
    Тема урока - выпадающее меню. Для работы вам нужна логическая переменная, начальное значение - false
    Кнопка, вызывающая меню, должна быть в одной "коробке" с самим меню, поэтому:
    Создайте Box без параметров, а внутри него:
        Кнопку FilledTonalButton, которая присваивает переменной "истину" (true);
        Элемент DropdownMenu, где:
            первый параметр - сама переменная;
            второй - действие, когда пользователь щёлкает мимо меню (нужно присвоить переменной "ложь");
            последний - блок {}, в котором находятся элементы меню:
                Каждый элемент - это DropdownMenuItem, в котором:
                    первый параметр - { блок }, содержащий нужный текстовый элемент;
                    второй - { действие } по нажатию пункта (пока просто присвоим ложь для закрытия меню);
                    третьим должен быть модификатор, но он нам не нужен, поэтому
                    четвёртый мы обязательно подписываем: leadingIcon = {}, в блоке поместите значок Icon.

    Используйте значки: Icons.Default.Create, Icons.Default.Share, Icons.Default.ExitToApp;
    Используйте разделитель Divider() перед последним элементом;
    Используйте exit в качестве параметра-действия для пункта "выход".

    Справка:
    https://metanit.com/kotlin/jetpack/4.17.php
*/