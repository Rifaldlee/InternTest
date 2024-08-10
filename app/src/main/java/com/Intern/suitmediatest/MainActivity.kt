package com.Intern.suitmediatest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.Intern.suitmediatest.model.PalindromeViewModel
import com.Intern.suitmediatest.model.Repository
import com.Intern.suitmediatest.model.UserListViewModel
import com.Intern.suitmediatest.model.ViewModelFactory
import com.Intern.suitmediatest.screen.FirstScreeen
import com.Intern.suitmediatest.screen.SecondScreen
import com.Intern.suitmediatest.screen.ThirdScreen
import com.Intern.suitmediatest.ui.theme.SuitmediaTestTheme

class MainActivity : ComponentActivity() {
    private lateinit var palindromeViewModel: PalindromeViewModel
    private lateinit var userListViewModel:  UserListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val repository = Repository()
        val viewModelFactory = ViewModelFactory(repository)

        palindromeViewModel = ViewModelProvider(this).get(PalindromeViewModel::class.java)
        userListViewModel = ViewModelProvider(this, viewModelFactory).get(UserListViewModel::class.java)

        setContent {
            SuitmediaTestTheme {
                var currentScreen by remember { mutableStateOf("first") }
                var userName by remember { mutableStateOf("") }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    when (currentScreen){
                        "first" -> FirstScreeen(
                            viewModel = palindromeViewModel,
                            navigateToSecondScreen = {
                                userName = it
                                currentScreen = "second"
                            }
                        )
                        "second" ->  SecondScreen(
                            viewModel = userListViewModel,
                            name = userName,
                            navigateBack = {currentScreen = "first"},
                            navigateToThirdScreen = { currentScreen = "third" }
                        )
                        "third" -> ThirdScreen(
                            viewModel = userListViewModel,
                            navigateBack = { currentScreen = "second" }
                        )
                    }
                }
            }
        }
    }
}

