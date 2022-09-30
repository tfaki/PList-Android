package com.loftymr.plist.res.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.loftymr.plist.ui.theme.PListColor

/**
 * Created by talhafaki on 29.09.2022.
 */

@Composable
fun PListOutlinedTextField(
    modifier: Modifier = Modifier,
    label: String,
    callbackText: (String) -> Unit
) {
    var fieldText by remember { mutableStateOf("") }
    OutlinedTextField(
        value = fieldText,
        onValueChange = {
            fieldText = it
            callbackText.invoke(it)
        },
        label = { Text(label) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = PListColor.White,
            unfocusedBorderColor = PListColor.Alabaster
        ),
        modifier = modifier
            .fillMaxWidth()
    )

}