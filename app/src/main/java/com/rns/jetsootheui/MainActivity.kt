package com.rns.jetsootheui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rns.jetsootheui.components.AlignYourBodySection
import com.rns.jetsootheui.components.FavouriteCollectionSection
import com.rns.jetsootheui.components.LandScapeNavigationRail
import com.rns.jetsootheui.components.PortraitNavigation
import com.rns.jetsootheui.components.SearchBar
import com.rns.jetsootheui.ui.theme.JetSootheUITheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetSootheUITheme {
                val windowSize = calculateWindowSizeClass(activity = this)
                SootheApp(windowSize)
            }
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(modifier.verticalScroll(rememberScrollState())) {
        Spacer(Modifier.height(16.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
        AlignYourBodySection()
        FavouriteCollectionSection()
    }
}

@Composable
fun AppPortrait() {
    Scaffold(
        bottomBar = {
            PortraitNavigation()
        }
    ) { padding ->
        HomeScreen(Modifier.padding(padding))
    }
}

@Composable
fun AppLandScape() {
    Surface(color = MaterialTheme.colorScheme.background) {
        Row {
            LandScapeNavigationRail()
            HomeScreen()
        }
    }
}

@Composable
fun SootheApp(windowSize: WindowSizeClass) {
    when (windowSize.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            AppPortrait()
        }

        WindowWidthSizeClass.Expanded -> {
            AppLandScape()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    JetSootheUITheme {
        HomeScreen()
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun AppPortraitPreview() {
    JetSootheUITheme {
        AppPortrait()
    }
}

@Preview(widthDp = 640, heightDp = 360)
@Composable
fun AppLandScapePreview() {
    JetSootheUITheme {
        AppLandScape()
    }
}







