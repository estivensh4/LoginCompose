package com.estiven.dev.logincompose.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.East
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.estiven.dev.logincompose.ui.theme.Orange200
import com.estiven.dev.logincompose.ui.theme.Orange700

@Composable
fun CustomButton(icon: ImageVector, text: String, onClick: () -> Unit) {
    val listColors = listOf(
        Orange200,
        Orange700
    )
    IconButton(
        onClick = { onClick() },
        modifier = Modifier
            .clip(CircleShape)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listColors,
                    tileMode = TileMode.Mirror
                )
            )
            .width(165.dp)
            .height(50.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp),
        ) {
            Text(
                text = text,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}

@Preview
@Composable
fun CustomButtonPreview() {
    CustomButton(icon = Icons.Filled.East, text = "SIGN UP", onClick = {})
}