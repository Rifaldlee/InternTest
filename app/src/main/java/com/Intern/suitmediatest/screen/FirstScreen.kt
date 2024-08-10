package com.Intern.suitmediatest.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
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

@Composable
fun FirstScreeen(){
    Column {
        FirstScreeenContent()
    }
}

@Composable
fun FirstScreeenContent(
    modifier: Modifier = Modifier,
){
    Box(
        modifier = Modifier
            .fillMaxSize()){
        Image(
            painter = painterResource(R.drawable.backgroung),
            contentDescription = stringResource(R.string.background),
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Image(
            painter = painterResource(R.drawable.contact),
            contentDescription = stringResource(id = R.string.profile),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
        )
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun FirstScreeenPreview(){
    MaterialTheme {
        FirstScreeen()
    }
}