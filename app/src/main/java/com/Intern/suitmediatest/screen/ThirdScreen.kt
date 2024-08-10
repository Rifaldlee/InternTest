package com.Intern.suitmediatest.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
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
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.Intern.suitmediatest.R
import com.Intern.suitmediatest.component.UserItem
import com.Intern.suitmediatest.data.DataItem
import com.Intern.suitmediatest.model.Repository
import com.Intern.suitmediatest.model.UserListViewModel

@Composable
fun ThirdScreen(
    viewModel: UserListViewModel,
    navigateBack: () -> Unit,
){
    Column {
        ThirdScreenContent(
            modifier = Modifier.fillMaxSize(),
            viewModel,
            navigateBack = navigateBack
        )
    }
}

@Composable
fun ThirdScreenContent(
    modifier: Modifier = Modifier,
    viewModel: UserListViewModel,
    navigateBack: () -> Unit,
){
    val data by viewModel.userList.observeAsState(initial = emptyList())

    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            contentAlignment = Alignment.Center
            ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = stringResource(R.string.back),
                tint = Color(0xFF554AF0),
                modifier = Modifier
                    .padding(start = 8.dp, top = 16.dp)
                    .size(40.dp)
                    .clickable { navigateBack() }
                    .align(Alignment.CenterStart)
            )
            Text(
                fontSize = 25.sp,
                text = stringResource(R.string.third_screen),
            )
        }
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = modifier
        ) {
            items(data) { user ->
                UserItem(data = user)
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun ThirdScreenPreview(){
    val dummyData = listOf(
        DataItem(
            id = 1,
            firstName = "George",
            lastName = "Bluth",
            email = "george.bluth@reqres.in",
            avatar = "https://reqres.in/img/faces/1-image.jpg"
        ),
        DataItem(
            id = 2,
            firstName = "Janet",
            lastName = "Weaver",
            email = "janet.weaver@reqres.in",
            avatar = "https://reqres.in/img/faces/2-image.jpg"
        )
    )
    val mockViewModel = object : UserListViewModel(Repository()) {
        override val userList: LiveData<List<DataItem>> = MutableLiveData(dummyData)
    }
    MaterialTheme {
        ThirdScreen(viewModel = mockViewModel) {
        }
    }
}