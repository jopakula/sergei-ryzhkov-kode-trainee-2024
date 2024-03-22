package com.example.kodetrainee2024.ui.components.EditTextField

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kodetrainee2024.R

@Suppress("FunctionName")
@Composable
fun EditTextField(
    value: String? = null,
    onValueChange: (String) -> Unit = {},
    hint: String = "Введи имя, тег, почту...",
    iconSearch: Painter = painterResource(id = R.drawable.icon_search),
    textSize: TextUnit = 15.sp,
    iconSize: Dp = 24.dp,
    colorBackGround: Color = colorResource(id = R.color.background_edit_text_field),
    hintColor: Color = colorResource(id = R.color.hint_color),
    iconMenu: ImageVector? = null,
    padding: Dp = 8.dp,
    roundingSize: Dp = 16.dp,
    clearText: String = "Отмена",
    clearTextColor: Color = colorResource(id = R.color.clear_text_color),
) {
    val focusRequester = remember { FocusRequester() }
    val interactionSource = remember { MutableInteractionSource() }

    Row(
        modifier =
            Modifier
                .padding(padding),
    ) {
        Row(
            modifier =
                Modifier
                    .weight(1F)
                    .background(
                        shape = RoundedCornerShape(roundingSize),
                        color = colorBackGround,
                    )
                    .padding(padding)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null,
                    ) { focusRequester.requestFocus() },
        ) {
            iconSearch.let {
                Icon(
                    modifier =
                        Modifier
                            .size(iconSize),
                    painter = iconSearch,
                    contentDescription = null,
                    tint = if (value.isNullOrEmpty()) hintColor else Color.Black,
                )
            }
            Spacer(
                modifier =
                    Modifier
                        .width(padding),
            )
            Box(
                modifier =
                    Modifier
                        .weight(1F)
                        .height(iconSize),
                contentAlignment = Alignment.CenterStart,
            ) {
                if (value.isNullOrEmpty() && hint.isNotEmpty()) {
                    Text(
                        text = hint,
                        fontSize = textSize,
                        color = hintColor,
                    )
                }
                BasicTextField(
                    modifier =
                        Modifier
                            .focusRequester(focusRequester),
                    value = value ?: "",
                    onValueChange = onValueChange,
                    textStyle =
                        TextStyle(
                            fontSize = textSize,
                        ),
                )
            }
            if (value.isNullOrEmpty() && iconMenu != null) {
                Icon(
                    modifier =
                        Modifier
                            .size(iconSize),
                    imageVector = iconMenu,
                    contentDescription = null,
                    tint = hintColor,
                )
            }
        }
        if (!value.isNullOrEmpty() && clearText.isNotEmpty()) {
            Text(
                text = clearText,
                color = clearTextColor,
                fontSize = textSize,
                modifier =
                    Modifier
                        .align(Alignment.CenterVertically)
                        .clickable { onValueChange("") }
                        .padding(padding),
            )
        }
    }
}
