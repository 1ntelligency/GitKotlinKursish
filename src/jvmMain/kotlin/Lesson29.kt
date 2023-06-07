import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import lessons.User
import ui.LazyVerticalGrid

@Composable    // reviews - "генератор бреда", список пар "пользователь-случайнаяФраза"
fun LessonReviews(reviews: List<Pair<User, String>>) {

}

/*  Задание повышенной сложности

    Исходный список reviews состоит из пар: Pair<User, String>. Чтобы определить, чей именно отзыв сейчас показан,
    создайте переменную этого же типа, но с возможностью принимать значение null. По умолчанию - null, отзыв не показан:
    var open: Pair<User, String>? by remember { mutableStateOf(null) }

    Ещё для правильного отображения карточки отзыва нужна переменная "высота" - её смещение от верхнего края экрана:
    var top by remember { mutableStateOf(0f) }

    Поскольку у нас есть скрытый анимированный элемент, главным объектом у нас будет Box,
        внутри Box - LazyVerticalGrid с фиксированным числом столбцов 3. Опционально - с прокруткой, как в уроке №23.
            внутри элемента items нашей сетки нужно создать ещё две внутренние переменные, "личные" для каждой карточки:
                var y by remember { mutableStateOf(0f) } - смещение карточки от верха экрана. Нужно для показа отзыва,
                val alpha = if (open == null || user == open) 1f else 0.5f
                    это прозрачность карточки. Если отзыв не показан, или же показан, но свой, от этого пользователя,
                    карточка полностью непрозрачна (1f). Если показан отзыв другого пользователя, полупрозрачна (0.5f).
            также внутри items создайте карточку пользователя (отступы на 5, закругление и возвышение на 10),
            примените к ней модификатор alpha (прозрачность), в качестве параметра укажите переменную alpha,
                внутри карточки - столбец с центрированием,
                    внутри - фото пользователя с отступами на 5 и обрезкой по той же фигуре, что у самой карточки,
                    а также серый текст подписи с нижним отступом на 5.

    Чтобы отобразить всплывающий отзыв именно в нужном месте экрана, каждая карточка пользователя должна "знать",
        на какой высоте (смещении от верха экрана) она расположена в любой момент времени.
        Для этого добавьте карточке ещё один модификатор: onGloballyPositioned {...}
        Код в этом блоке выполняется каждый раз, когда карточка создаётся или перемещается по экрану при прокрутке.
        Присвоим в этом блоке готовое значение смещения для всплывающего отзыва, если оно вдруг понадобится:
        y = it.positionInParent().y + it.size.height - 28
        примечание: к смещению добавляем высоту карточки минус высота подписи, отзыв будет открываться чуть ниже фото.

    Элементу внутри карточки (столбцу) добавьте модификатор clickable, в котором пропишите два действия:
        open = текущий элемент списка // таким образом отзыв будет показан на экране
        top = y // запомненная чуть ранее высота "y" присваивается переменной top для дальнейшего показа отзыва.

    Осталось отобразить сам отзыв. Внутри общего Box, но ПОСЛЕ окончания LazyVerticalGrid добавьте элемент:
        AnimatedVisibility(open != null, Modifier.offset(y = top.dp)) { ... }
        Этот элемент будет виден только когда карточка пользователя была выбрана (open равно чему-то),
        причём при появляться/исчезать этот объект будет плавно, с анимацией. Как видите, объекту задан модификатор
        смещения на top единиц, чтобы отзыв отобразился точно под выбранным пользователем.

        Внутри этого объекта создайте карточку на всю ширину экрана (отступы на 5, закругление и возвышение на 10),
            внутри неё - столбец с отступами на 10,
                внутри столбца - два текста, отзыв и ФИО пользователя (серый курсив, выравнивание по правому краю).
            Столбцу придайте модификатор clickable, обнуляющий выбор пользователя (open = null).

    Чтобы прозрачность карточек пользователей менялась не рывком, а плавно, попробуйте вместо
        val alpha = if (open == null || user == open) 1f else 0.5f
        написать анимацию этого значения:
        val alpha by animateFloatAsState(if (open == null || review == open) 1f else 0.5f)
*/