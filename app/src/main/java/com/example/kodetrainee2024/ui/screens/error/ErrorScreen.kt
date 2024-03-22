package com.example.kodetrainee2024.ui.screens.error

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.example.kodetrainee2024.R

@Suppress("ktlint:standard:function-naming")
@Composable
fun ErrorScreen(onRetry: () -> Unit) {
    Column(
        modifier =
            Modifier
                .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(painter = painterResource(id = R.drawable.ufo), contentDescription = null)
        Text(
            text = "Какой-то сверхразум все сломал",
            fontSize = 17.sp,
            color = Color.Black,
        )
        Text(
            text = "Постараемся быстро поченить",
            fontSize = 16.sp,
            color = Color(R.color.hint_color),
        )
        Text(
            modifier =
                Modifier
                    .clickable { onRetry() },
            text = "Попробовать снова",
            fontSize = 16.sp,
            color = Color(R.color.clear_text_color),
        )
    }
}
