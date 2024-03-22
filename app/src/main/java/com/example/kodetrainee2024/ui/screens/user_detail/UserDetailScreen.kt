package com.example.kodetrainee2024.ui.screens.user_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kodetrainee2024.R
import com.example.kodetrainee2024.data.http_client.models.User
import com.google.accompanist.coil.rememberCoilPainter

@Suppress("ktlint:standard:function-naming")
@Composable
fun UserDetailScreen(
    user: User,
    onBack: () -> Unit,
) {
    Column(
        modifier =
            Modifier
                .fillMaxHeight(0.5F),
    ) {
        Column(
            modifier =
                Modifier
                    .background(Color(R.color.background_edit_text_field)),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier =
                    Modifier
                        .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
            ) {
                Icon(
                    modifier =
                        Modifier
                            .size(24.dp)
                            .padding(top = 10.dp, start = 10.dp)
                            .clickable { onBack() },
                    painter = painterResource(id = R.drawable.icon_back),
                    contentDescription = null,
                )
            }

            Image(
                painter = rememberCoilPainter(request = user.avatarUrl),
                contentDescription = "User Avatar",
                modifier =
                    Modifier
                        .size(104.dp)
                        .clip(CircleShape),
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.size(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "${user.firstName} ${user.lastName}",
                    style = TextStyle(fontSize = 24.sp, color = Color.Black),
                )
                Spacer(modifier = Modifier.size(4.dp))
                Text(
                    text = user.userTag,
                    style = TextStyle(fontSize = 17.sp, color = Color(R.color.tab_text_color)),
                )
            }
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = user.department,
                style = TextStyle(fontSize = 13.sp, color = Color(R.color.hint_color)),
            )
            Spacer(modifier = Modifier.size(16.dp))
        }
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Spacer(modifier = Modifier.size(8.dp))
            Row(
                modifier =
                    Modifier
                        .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    modifier =
                        Modifier
                            .size(24.dp),
                    painter = painterResource(id = R.drawable.icon_star),
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.size(12.dp))
                Text(
                    text = user.birthday,
                    style = TextStyle(fontSize = 14.sp, color = Color.Black),
                )
            }
            Spacer(
                modifier =
                    Modifier
                        .size(12.dp),
            )
            Row(
                modifier =
                    Modifier
                        .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    modifier =
                        Modifier
                            .size(24.dp),
                    painter = painterResource(id = R.drawable.icon_phone),
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.size(12.dp))
                Text(
                    text = user.phone,
                    style = TextStyle(fontSize = 14.sp, color = Color.Black),
                )
            }
        }
    }
}
