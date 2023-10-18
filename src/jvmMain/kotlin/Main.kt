import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
        Lessons.ControlMenu -> Box(Modifier.fillMaxSize()) { LessonMenu(exit) }
        Lessons.ControlBack -> LessonBack()

        Lessons.ListSimple -> LessonSimple(colors)
        Lessons.ListPadding -> LessonPadding(colors)
        Lessons.ListRows -> LessonRows(icons)
        Lessons.ListColumns -> LessonColumns(fruits)
        Lessons.ListCards -> LessonCards(fruits)
        Lessons.ListUsers -> LessonUsers(users)
        Lessons.ListLongList -> LessonLongList(fruits(500))
        Lessons.ListLongRow -> LessonLongRow(fruits(500))
        Lessons.ListPager -> Box { LessonPager(users) }
        Lessons.ListVGrid -> LessonVGrid(fruits(500))
        Lessons.ListHGrid -> LessonHGrid(users)
        Lessons.ListChat -> LessonChat(remember { rave() }.collectAsState(listOf()).value)
        Lessons.ListRave -> LessonReviews(users.zip(rave))
        Lessons.ListUserList -> LessonUserList(users)

        Lessons.UiAction -> Box(Modifier.padding(10.dp), contentAlignment = Alignment.BottomEnd) { LessonAction(exit) }
        Lessons.UiExtAction -> Box(Modifier.padding(10.dp), contentAlignment = Alignment.BottomEnd) { LessonExtAction(exit) }
        Lessons.UiTopBar -> Box(Modifier.fillMaxSize()) { LessonTopBar(exit) }
        Lessons.UiBottomBar -> Box(Modifier.fillMaxSize(), Alignment.BottomStart) { LessonBottomBar(exit) }
        Lessons.UiScaffold -> LessonScaffold(exit)
        Lessons.UiSnackbar -> LessonSnackbar()
        Lessons.UiDrawer -> LessonDrawer(exit)
        Lessons.UiTest -> LessonUI(exit)

        Lessons.ApiCities -> LessonCities()
        Lessons.ApiRegions -> LessonRegions()
        Lessons.ApiRegionCities -> LessonRegionCities()
        Lessons.ApiWeatherCities -> LessonWeatherCities()
        Lessons.ApiSearchPrice -> LessonSearchPrice()
        Lessons.ApiAlphaPages -> LessonAlphaPages()
        Lessons.ApiNumberPages -> LessonNumberPages()
        Lessons.ApiInfinity -> LessonInfinity()
        Lessons.ApiGenres -> LessonGenres(exit)
        Lessons.ApiSearch -> LessonSearch()
        Lessons.ApiLikes -> LessonLikes()
        Lessons.ApiRegister -> LessonRegistration()
        Lessons.ApiLogin -> LessonLogin()
        Lessons.ApiInbox -> LessonInbox( remember { users.map { it.photo } } )
        Lessons.ApiDelete -> LessonDelete( remember { users.map { it.photo } } )
        Lessons.ApiSend -> LessonSend()
        Lessons.ApiSent -> LessonSent()

        Lessons.ExtFriends -> LessonFriends(users)
        else -> {}
    }
}
