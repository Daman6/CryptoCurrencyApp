package com.example.cryptocurrencyapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.MutableLiveData
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.cryptocurrencyapp.domain.model.Coin
import com.example.cryptocurrencyapp.presentation.MainActivity
import com.example.cryptocurrencyapp.presentation.Screen
import com.example.cryptocurrencyapp.presentation.coin_list.components.CoinListScreen
import com.example.cryptocurrencyapp.presentation.coin_list.components.CoinListState
import com.example.cryptocurrencyapp.presentation.coin_list.components.CoinListViewModel
import com.example.cryptocurrencyapp.presentation.ui.theme.CryptoCurrencyAppTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.MutableStateFlow

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

//    @HiltAndroidTest
//    class LandingScreenTest {
//        val hiltRule = HiltAndroidRule(this)
//
//
//        @Before
//        fun init() {
//            hiltRule.inject()
//        }
//    }
    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun SetUp() {
        composeTestRule.setContent {
            MockKAnnotations.init(this)

//            // Set up test data
            val coins = mutableListOf<Coin>(
                Coin(id = "1", name = "Bitcoin", symbol = "BTC", is_active = true, rank = 1),
                Coin(id = "2", name = "Ethereum", symbol = "ETH", is_active = false, rank = 2),
                Coin(id = "3", name = "Litecoin", symbol = "LTC", is_active = true, rank = 3)
            )
            val coinListState = mutableStateOf<CoinListState>(
                CoinListState(isLoading = false,coins=coins, error="")
            )
            val state : State<CoinListState> =coinListState

            // Set up view model mock
            val viewModel = mockk<CoinListViewModel>()



            val navController = rememberNavController()
            CryptoCurrencyAppTheme {
                NavHost(
                    navController = navController,
                    startDestination = Screen.CoinListScreen.route
                )
                {
                    composable(route = Screen.CoinListScreen.route) {
                        CoinListScreen(viewModel)
                    }
                    composable(route = Screen.CoinDetailScreen.route) {
                        CoinListScreen(viewModel)
                    }
                }
            }
        }
    }

    @Test
    fun bhb(){
        composeTestRule.onNodeWithText("Daman").assertExists()
    }



}

