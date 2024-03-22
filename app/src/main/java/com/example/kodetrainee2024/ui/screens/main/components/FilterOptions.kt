package com.example.kodetrainee2024.ui.screens.main.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Suppress("ktlint:standard:function-naming")
@Composable
fun FilterOptions(
    isSheetOpen: Boolean,
    onDismissRequest: () -> Unit,
    onFilterAlphabetSelected: (Boolean) -> Unit,
    initialSort: String,
    onSortSelected: (String) -> Unit,
) {
    val sheetState = rememberModalBottomSheetState()
    val selectedSort = rememberSaveable { mutableStateOf(initialSort) }

    if (isSheetOpen) {
        ModalBottomSheet(
            modifier =
                Modifier
                    .fillMaxHeight(0.3F),
            sheetState = sheetState,
            onDismissRequest = onDismissRequest,
        ) {
            Column(
                modifier =
                    Modifier
                        .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Сортировка",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                )
            }
            Column(
                modifier =
                    Modifier
                        .fillMaxSize(),
                horizontalAlignment = Alignment.Start,
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    RadioButton(
                        selected = selectedSort.value == "По алфавиту",
                        onClick = {
                            selectedSort.value = "По алфавиту"
                            onFilterAlphabetSelected(true)
                            onSortSelected("По алфавиту")
                        },
                    )
                    Text(
                        modifier =
                            Modifier
                                .clickable {
                                    selectedSort.value = "По алфавиту"
                                    onFilterAlphabetSelected(true)
                                    onSortSelected("По алфавиту")
                                },
                        text = "По алфавиту",
                    )
                }
                Spacer(modifier = Modifier.size(16.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    RadioButton(
                        selected = selectedSort.value == "По дню рождения",
                        onClick = {
                            selectedSort.value = "По дню рождения"
                            onFilterAlphabetSelected(false)
                            onSortSelected("По дню рождения")
                        },
                    )
                    Text(
                        modifier =
                            Modifier
                                .clickable {
                                    selectedSort.value = "По дню рождения"
                                    onFilterAlphabetSelected(false)
                                    onSortSelected("По дню рождения")
                                },
                        text = "По дню рождения",
                    )
                }
            }
        }
    }
}
