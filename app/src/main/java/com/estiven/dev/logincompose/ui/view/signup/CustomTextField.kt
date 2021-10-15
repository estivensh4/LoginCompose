package com.estiven.dev.logincompose.ui.view.signup

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.estiven.dev.logincompose.ui.theme.Shapes

@Composable
fun CustomTextField(
    icon: ImageVector,
    label: String,
    value: String
) {

    TextField(
        value = value,
        label = {
            Text(
                text = label
            )
        },
        singleLine = true,
        onValueChange = { value = it },
        leadingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = null
            )
        },
        shape = Shapes.medium,
        modifier = Modifier
            .shadow(15.dp)
            .fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            textColor = Color.Black,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        )
    )
}


@Preview
@Composable
fun PreviewCustomTextField() {

}