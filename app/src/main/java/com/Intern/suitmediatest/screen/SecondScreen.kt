package com.Intern.suitmediatest.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.Intern.suitmediatest.R
import com.Intern.suitmediatest.component.CustomButton
import com.Intern.suitmediatest.model.Repository
import com.Intern.suitmediatest.model.UserListViewModel

@Composable
fun SecondScreen(
    viewModel: UserListViewModel,
    name: String,
    navigateBack: () -> Unit,
    navigateToThirdScreen: () -> Unit
){
    Column {
        SecondScreenContent(
            modifier = Modifier.fillMaxSize(),
            viewModel,
            name = name,
            navigateBack = navigateBack,
            navigateToThirdScreen = navigateToThirdScreen
        )
    }
}

@Composable
fun SecondScreenContent(
    modifier: Modifier = Modifier,
    viewModel: UserListViewModel,
    name: String,
    navigateBack: () -> Unit,
    navigateToThirdScreen: () -> Unit
){
    val selectedUserName by viewModel.selectedUserName.observeAsState("")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = stringResource(id = R.string.back),
                tint = Color(0xFF554AF0),
                modifier = Modifier
                    .size(40.dp)
                    .clickable { navigateBack() }
                    .align(Alignment.CenterStart)
            )
            Text(
                fontSize = 25.sp,
                text = stringResource(id = R.string.third_screen),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            fontSize = 18.sp,
            text = stringResource(id = R.string.welcome),
        )
        Text(
            fontSize = 25.sp,
            text = name,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            fontSize = 25.sp,
            text = if (selectedUserName.isNotEmpty()) selectedUserName else stringResource(id = R.string.selected_username),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.weight(1f))
        CustomButton(
            text = stringResource(id = R.string.choose),
            onClick = { navigateToThirdScreen() }
        )
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun SecondScreenPreview(){
    val repository = Repository()
    val viewModel = UserListViewModel(repository = repository)
    MaterialTheme {
        SecondScreen(
            viewModel = viewModel,
            name = "John Doe",
            navigateBack = {},
            navigateToThirdScreen = {}
        )
    }
}