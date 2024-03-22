package com.example.kodetrainee2024.ui.screens.main.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.kodetrainee2024.R

@Suppress("ktlint:standard:function-naming")
@Composable
fun TabsHeaders(
    tabs: List<Tabs>,
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit,
) {
    ScrollableTabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = Modifier.fillMaxWidth(),
        edgePadding = 14.dp,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                color = colorResource(R.color.clear_text_color),
                modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
            )
        },
    ) {
        tabs.forEachIndexed { index, tab ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = { onTabSelected(index) },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color(R.color.tab_text_color),
                text = { Text(text = tab.text) },
            )
        }
    }
}
