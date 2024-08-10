package com.Intern.suitmediatest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.Intern.suitmediatest.model.Repository
import com.Intern.suitmediatest.model.UserListViewModel
import com.Intern.suitmediatest.model.ViewModelFactory
import com.Intern.suitmediatest.screen.ThirdScreen
import com.Intern.suitmediatest.ui.theme.SuitmediaTestTheme

class MainActivity : ComponentActivity() {
    private val viewModel: UserListViewModel by viewModels {
        ViewModelFactory(Repository())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        viewModel.getUsers()

        setContent {
            SuitmediaTestTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ThirdScreen(viewModel = viewModel, navigateBack = {})
                }
            }
        }
    }
}

