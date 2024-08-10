package com.Intern.suitmediatest.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.Intern.suitmediatest.R
import com.Intern.suitmediatest.data.DataItem
import com.Intern.suitmediatest.ui.theme.SuitmediaTestTheme

@Composable
fun UserItem(
    data: DataItem,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
){
    Column(
        modifier = modifier
            .background(Color.White)
            .fillMaxWidth()
            .height(87.dp)
            .border(
                width = 1.dp,
                color = Color(0x26000000),
                shape = RoundedCornerShape(size = 10.dp)
            )
            .padding(12.dp)
            .clickable { onClick() }
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
        ) {
            AsyncImage(
                model = data.avatar,
                contentDescription = stringResource(id = R.string.profile),
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .height(64.dp)
                    .width(64.dp)
                    .clip(CircleShape)
            )
            Column(modifier = Modifier.padding(start = 10.dp)){
                Row(
                    modifier = modifier
                        .padding(bottom = 4.dp)
                ) {
                    Text(
                        text = data.firstName.toString(),
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(end = 4.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = data.lastName.toString(),
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = data.email.toString(),
                    color = Color.Black,
                    modifier = modifier
                        .fillMaxWidth()
                )
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun UserItemPreview(){

    MaterialTheme {
        val data = DataItem(
            id = 1,
            firstName = "Rifaldlee",
            lastName = "Rifaldlee",
            avatar = "R.drawable.food",
            email = "@gmail.com",
        )
        UserItem(
            data = data,
            modifier = Modifier,
            onClick = {}
        )
    }
}