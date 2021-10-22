package com.estiven.dev.logincompose.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.estiven.dev.logincompose.R

@Composable
fun ButtonSocialNetwork(
    icon: Int,
    text: String,
    loading: Boolean,
    active: Boolean,
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick() },
        modifier = Modifier
            .clip(CircleShape)
            .width(165.dp)
            .height(50.dp),
        enabled = active,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
        elevation = ButtonDefaults.elevation(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp),
        ) {
            if (loading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(30.dp)
                )
            } else {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = null,
                )
                Text(
                    text = text,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview
@Composable
fun ButtonGooglePreview() {
    ButtonSocialNetwork(
        icon = R.drawable.google,
        text = "GOOGLE",
        loading = false,
        false,
        onClick = {})


}
