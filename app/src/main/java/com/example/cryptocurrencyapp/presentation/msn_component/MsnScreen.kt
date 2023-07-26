package com.example.cryptocurrencyapp.presentation.msn_component

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cryptocurrencyapp.presentation.Screen
import dagger.hilt.android.AndroidEntryPoint

@Composable
fun MsnScreen(
//    navController: NavController,
    viewModel: MsnViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Log.e("result","Result-"+state.error.toString())
    Log.e("result","Result-"+state.coins.toString())
//    Box(modifier = Modifier.fillMaxSize()){
//            Text(text = state.coins.errorCode.toString(), color = Color.Black)
//        }
//        if (state.error.isNotBlank()){
//            Text(
//                text = state.error,
//                color = MaterialTheme.colors.error,
//                textAlign = TextAlign.Center,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 20.dp)
//                    .align(Alignment.Center)
//            )
//        }
//        if(state.isLoading){
//            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
//        }
    }
