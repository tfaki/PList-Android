package com.loftymr.plist.res.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.loftymr.plist.ui.theme.PListColor

/**
 * Created by talhafaki on 29.09.2022.
 */

@Composable
fun PListButton(modifier: Modifier = Modifier, buttonText: String, onClick: () -> Unit) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(horizontal = 16.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Button(
            onClick = { onClick.invoke() },
            modifier = Modifier
                .fillMaxSize(),
            colors = ButtonDefaults.buttonColors(backgroundColor = PListColor.Alabaster)
        ) {
            Text(
                text = buttonText,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(align = Alignment.Center),
                style = MaterialTheme.typography.h1.copy(
                    fontSize = 18.sp,
                    color = PListColor.SolidBlue
                )
            )
        }
    }
}