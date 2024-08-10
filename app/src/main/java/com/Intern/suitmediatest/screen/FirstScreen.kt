package com.Intern.suitmediatest.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.Intern.suitmediatest.R
import com.Intern.suitmediatest.component.CustomButton
import com.Intern.suitmediatest.component.CustomTextField
import com.Intern.suitmediatest.model.PalindromeViewModel

@Composable
fun FirstScreeen(
    viewModel: PalindromeViewModel,
    navigateToSecondScreen: (String) -> Unit
){
    Column {
        FirstScreenContent(
            modifier = Modifier.fillMaxSize(),
            viewModel,
        )
        if (viewModel.navigateToSecondScreen) {
            viewModel.onNavigationHandled()
            navigateToSecondScreen(viewModel.name)
        }
    }
}

@Composable
fun FirstScreenContent(
    modifier: Modifier = Modifier,
    viewModel: PalindromeViewModel
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.backgroung),
            contentDescription = stringResource(id = R.string.background),
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.contact),
                contentDescription = stringResource(id = R.string.profile),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(20.dp))
            CustomTextField(
                value = viewModel.name,
                onValueChange = { viewModel.name = it },
                placeholder = stringResource(id = R.string.name)
            )
            Spacer(modifier = Modifier.height(20.dp))
            CustomTextField(
                value = viewModel.sentence,
                onValueChange = { viewModel.sentence = it },
                placeholder = stringResource(id = R.string.palindrome)
            )
            Spacer(modifier = Modifier.height(38.dp))
            CustomButton(
                text = stringResource(id = R.string.check),
                onClick = { viewModel.onCheckPalindrome() }
            )
            Spacer(modifier = Modifier.height(16.dp))
            CustomButton(
                text = stringResource(id = R.string.next),
                onClick = { viewModel.onNext() }
            )
        }

        if (viewModel.showDialog) {
            AlertDialog(
                onDismissRequest = { viewModel.onDialogDismiss() },
                title = { Text(text = stringResource(id = R.string.result)) },
                text = {
                    Text(
                        text = if (viewModel.isPalindrome) "Palindrome" else "Not Palindrome"
                    )
                },
                confirmButton = {
                    TextButton(onClick = { viewModel.onDialogDismiss() }) {
                        Text("OK")
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun FirstScreeenPreview(){
    val viewModel = PalindromeViewModel()
    MaterialTheme {
        FirstScreeen(
            viewModel = viewModel,
            navigateToSecondScreen = {})
    }
}