package com.example.kodetrainee2024.ui.screens.main.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kodetrainee2024.R
import com.example.kodetrainee2024.data.http_client.models.User
import com.google.accompanist.coil.rememberCoilPainter

@Suppress("ktlint:standard:function-naming")
@Composable
fun UserCard(
    user: User,
    onClick: () -> Unit,
) {
    Row(
        modifier =
            Modifier
                .clickable { onClick() }
                .padding(8.dp)
                .clip(RoundedCornerShape(8.dp))
                .fillMaxWidth()
                .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = rememberCoilPainter(request = user.avatarUrl),
            contentDescription = "User Avatar",
            modifier =
                Modifier
                    .size(72.dp)
                    .clip(CircleShape),
            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = Modifier.size(10.dp))
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "${user.firstName} ${user.lastName}",
                    style = TextStyle(fontSize = 16.sp, color = Color.Black),
                )
                Spacer(modifier = Modifier.size(4.dp))
                Text(
                    text = user.userTag,
                    style = TextStyle(fontSize = 13.sp, color = Color(R.color.tab_text_color)),
                )
            }
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = user.department,
                style = TextStyle(fontSize = 14.sp, color = Color(R.color.hint_color)),
            )
        }
    }
}
