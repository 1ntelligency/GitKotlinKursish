import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import lessons.*
import ui.mainUI

fun main() = mainUI { lesson, exit ->
    when(lesson) {
        Lessons.TextColumn -> LessonColumn()
        Lessons.TextRow -> LessonRow()
        Lessons.TextBox -> LessonCompass()
        Lessons.TextDossier -> LessonJamesBond(bond)

        Lessons.ControlButton -> LessonButtons()
        Lessons.ControlImage -> LessonImages()
        Lessons.ControlSwitch -> LessonSwitches()
        Lessons.ControlRadio -> LessonRadios()
        Lessons.ControlCheck -> LessonChecks()
        Lessons.ControlFields -> LessonTextFields()
        Lessons.ControlFieldTypes -> LessonTextFieldTypes()
        Lessons.ControlRegForm -> LessonRegForm(exit)
        Lessons.ControlSliders -> LessonSliders()
        Lessons.ControlProgress -> LessonProgress()
        Lessons.ControlMenu -> LessonMenu(exit)
        Lessons.ControlBack -> LessonBack()

        Lessons.ListSimple -> LessonSimple(colors)
        Lessons.ListPadding -> LessonPadding(colors)
        Lessons.ListRows -> LessonRows(icons)
        Lessons.ListColumns -> LessonColumns(fruits)
        Lessons.ListCards -> LessonCards(fruits)
        Lessons.ListUsers -> LessonUsers(users)
        Lessons.ListLongList -> LessonLongList(fruits(500))
        Lessons.ListLongRow -> LessonLongRow(fruits(500))
        Lessons.ListPager -> LessonPager(users)
        Lessons.ListVGrid -> LessonVGrid(fruits(500))
        Lessons.ListHGrid -> LessonHGrid(users)
        Lessons.ListChat -> LessonChat(remember { rave() }.collectAsState(listOf()).value)
        Lessons.ListRave -> LessonReviews(users.zip(rave))
        Lessons.ListUserList -> LessonUserList(users)

        Lessons.UiAction -> LessonAction(exit)
        Lessons.UiExtAction -> LessonExtAction(exit)
        Lessons.UiTopBar -> LessonTopBar(exit)
        Lessons.UiBottomBar -> LessonBottomBar(exit)
        Lessons.UiScaffold -> LessonScaffold(exit)
        Lessons.UiSnackbar -> LessonSnackbar()
        Lessons.UiDrawer -> LessonDrawer(exit)
        Lessons.UiTest -> LessonUI(exit)

        //else -> {}
    }
}
