package com.estiven.dev.logincompose.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.estiven.dev.logincompose.R

val fonts = FontFamily(
    Font(resId = R.font.montserrat_black, weight = FontWeight.Black),
    Font(
        resId = R.font.montserrat_blackitalic,
        weight = FontWeight.Black,
        style = FontStyle.Italic
    ),
    Font(resId = R.font.montserrat_bold, weight = FontWeight.Bold),
    Font(resId = R.font.montserrat_bolditalic, weight = FontWeight.Bold, style = FontStyle.Italic),
    Font(resId = R.font.montserrat_extrabold, weight = FontWeight.ExtraBold),
    Font(
        resId = R.font.montserrat_extrabolditalic,
        weight = FontWeight.ExtraBold,
        style = FontStyle.Italic
    ),
    Font(resId = R.font.montserrat_extralight, weight = FontWeight.ExtraLight),
    Font(
        resId = R.font.montserrat_extralightitalic,
        weight = FontWeight.ExtraLight,
        style = FontStyle.Italic
    ),
    Font(resId = R.font.montserrat_italic, weight = FontWeight.Normal, style = FontStyle.Italic),
    Font(resId = R.font.montserrat_light, weight = FontWeight.Light),
    Font(
        resId = R.font.montserrat_lightitalic,
        weight = FontWeight.Light,
        style = FontStyle.Italic
    ),
    Font(resId = R.font.montserrat_medium, weight = FontWeight.Medium),
    Font(
        resId = R.font.montserrat_mediumitalic,
        weight = FontWeight.Medium,
        style = FontStyle.Italic
    ),
    Font(resId = R.font.montserrat_regular, weight = FontWeight.Normal),
    Font(resId = R.font.montserrat_semibold, weight = FontWeight.SemiBold),
    Font(
        resId = R.font.montserrat_semibolditalic,
        weight = FontWeight.SemiBold,
        style = FontStyle.Italic
    ),
    Font(resId = R.font.montserrat_thin, weight = FontWeight.Thin),
    Font(resId = R.font.montserrat_thinitalic, weight = FontWeight.Thin, style = FontStyle.Italic)
)