package info.fekri.composeboom.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dev.burnoo.cokoin.Koin
import dev.burnoo.cokoin.navigation.KoinNavHost
import info.fekri.composeboom.di.myModules
import info.fekri.composeboom.ui.feature.aboutUs.AboutUsScreen
import info.fekri.composeboom.ui.feature.entry1.FirstEntryScreen
import info.fekri.composeboom.ui.feature.entry2.EntrySecondScreen
import info.fekri.composeboom.ui.feature.main.MainScreen
import info.fekri.composeboom.ui.feature.showbook.ShowBookScreen
import info.fekri.composeboom.ui.feature.splash.SplashScreen
import info.fekri.composeboom.ui.theme.BackgroundMain
import info.fekri.composeboom.ui.theme.ComposeBoomTheme
import info.fekri.composeboom.util.IS_USER_FIRST_TIME
import info.fekri.composeboom.util.KEY_SHOW_BOOK
import info.fekri.composeboom.util.MyScreens
import org.koin.android.ext.koin.androidContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.layoutDirection = View.LAYOUT_DIRECTION_LTR
        val sharedPreferences = getSharedPreferences("my_fist_t_checker_sh", Context.MODE_PRIVATE)
        val isFirstTime = sharedPreferences.getBoolean(IS_USER_FIRST_TIME, true)
        if (isFirstTime) {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putBoolean(IS_USER_FIRST_TIME, false)
            editor.apply()
        }
        setContent {
            Koin(appDeclaration = {
                androidContext(this@MainActivity)
                modules(myModules)
            }) {
                ComposeBoomTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = BackgroundMain
                    ) {
                        MainAppUi(isFirstTime)
                    }
                }
            }
        }
    }
}

@Composable
fun MainAppUi(isFirstTime: Boolean) {
    val controller = rememberNavController()

    KoinNavHost(navController = controller, startDestination = MyScreens.ShowBookScreen.route) {

        composable(route = MyScreens.EntryScreenFirst.route) {
            FirstEntryScreen()
        }

        composable(MyScreens.EntryScreenSecond.route) {
            EntrySecondScreen()
        }

        composable(MyScreens.MainScreen.route) {
            MainScreen()
        }

        composable(
            MyScreens.ShowBookScreen.route //+ "/{$KEY_SHOW_BOOK}",
//            arguments = listOf(navArgument(KEY_SHOW_BOOK) {
//                type = NavType.StringType
//            })
        ) {
            ShowBookScreen(/*it.arguments!!.getString(KEY_SHOW_BOOK, "null")*/)
        }

        composable(MyScreens.SplashScreen.route) {
            SplashScreen(isFirstTime)
        }

        composable(MyScreens.SearchScreen.route) {
            SearchScreen()
        }

        composable(MyScreens.AboutUsScreen.route) {
            AboutUsScreen()
        }

        composable(MyScreens.VoiceLibScreen.route) {
            VoiceLibScreen()
        }

        composable(MyScreens.VideoLibScreen.route) {
            VideoLibScreen()
        }

        composable(MyScreens.PhotoLibScreen.route) {
            PhotoLibScreen()
        }

    }

}

@Composable
fun PhotoLibScreen() {

}

@Composable
fun VideoLibScreen() {

}

@Composable
fun VoiceLibScreen() {

}



@Composable
fun SearchScreen() {

}

