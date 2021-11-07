package com.wesleymentoor.devoverflow.presentation.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wesleymentoor.devoverflow.R

@Composable
fun ErrorScreen(
    error: String,
    onClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.no_internet_connection), 
            contentDescription = error)
        Spacer(modifier = Modifier.padding(4.dp))
        Text(
            text = error,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.padding(4.dp))

        Button(
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp)
                .border(BorderStroke(2.dp, color = LocalContentColor.current))
                .fillMaxWidth(),
            onClick = { onClick() }) {

            Text(text = "Try again")
        }
    }
}


@Preview("Light Mode")
@Composable
fun PreviewErrorScreen(error: String = "") {

}