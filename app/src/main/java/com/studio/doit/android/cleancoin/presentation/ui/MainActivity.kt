package com.studio.doit.android.cleancoin.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.studio.doit.android.cleancoin.common.ParamKey
import com.studio.doit.android.cleancoin.presentation.ui.coin.detail.CoinDetailScree
import com.studio.doit.android.cleancoin.presentation.ui.coin.list.CoinListScreen
import com.studio.doit.android.cleancoin.presentation.ui.theme.CleanCoinAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanCoinAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Navigation.CoinListScreen.screen
                    ) {
                        composable(
                            route = Navigation.CoinListScreen.screen
                        ) {
                            CoinListScreen(navController = navController)
                        }

                        composable(
                            route = Navigation.CoinDetailScreen.screen + "/{${ParamKey.COIN_ID}}"
                        ) {
                            CoinDetailScree()
                        }
                    }
                }
            }
        }
    }
}