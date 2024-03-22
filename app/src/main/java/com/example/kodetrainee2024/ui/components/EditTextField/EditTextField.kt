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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kodetrainee2024.R
import com.example.kodetrainee2024.ui.screens.main.components.FilterOptions

@Suppress("FunctionName")
@Composable
fun EditTextField(
    value: String? = null,
    onValueChange: (String) -> Unit = {},
    hint: String? = null,
    iconSearch: Painter = painterResource(id = R.drawable.icon_search),
    textSize: TextUnit = 16.sp,
    iconSize: Dp = 22.dp,
    hintColor: Color = Color(R.color.hint_color),
    iconMenu: Painter = painterResource(id = R.drawable.icon_list_ui_alt),
    padding: Dp = 8.dp,
    roundingSize: Dp = 14.dp,
    clearText: String? = null,
    clearTextColor: Color = colorResource(id = R.color.clear_text_color),
    onFilterAlphabetSelected: (Boolean) -> Unit,
    initialSort: String,
    onSortSelected: (String) -> Unit,
) {
    val colorBackGround = colorResource(id = R.color.edit_text_background)
    val focusRequester = remember { FocusRequester() }
    val interactionSource = remember { MutableInteractionSource() }

    var isSheetOpen by remember { mutableStateOf(false) }
    var searchQuery by remember { mutableStateOf("") }

    if (isSheetOpen) {
        FilterOptions(
            isSheetOpen = isSheetOpen,
            onDismissRequest = { isSheetOpen = false },
            onFilterAlphabetSelected = onFilterAlphabetSelected,
            initialSort = initialSort,
            onSortSelected = onSortSelected,
        )
    }

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
                    painter = it,
                    contentDescription = null,
                    tint = if (value.isNullOrEmpty()) hintColor else Color.Black,
                )
            }
            Spacer(
                modifier =
                    Modifier
                        .width((iconSize / 4)),
            )
            Box(
                modifier =
                    Modifier
                        .weight(1F)
                        .height(iconSize),
                contentAlignment = Alignment.CenterStart,
            ) {
                if (value.isNullOrEmpty() && !hint.isNullOrEmpty()) {
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
                    onValueChange = { newQuery ->
                        searchQuery = newQuery
                        onValueChange(newQuery)
                    },
                    textStyle =
                        TextStyle(
                            fontSize = textSize,
                        ),
                )
            }
            if (value.isNullOrEmpty()) {
                Icon(
                    modifier =
                        Modifier
                            .size(iconSize)
                            .clickable { isSheetOpen = true },
                    painter = iconMenu,
                    contentDescription = null,
                    tint = hintColor,
                )
            }
        }
        if (!value.isNullOrEmpty() && !clearText.isNullOrEmpty()) {
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
