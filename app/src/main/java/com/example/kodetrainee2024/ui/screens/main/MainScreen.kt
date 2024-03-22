package com.example.kodetrainee2024.ui.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.kodetrainee2024.data.http_client.HttpClient
import com.example.kodetrainee2024.data.http_client.models.User
import com.example.kodetrainee2024.ui.components.EditTextField.EditTextField
import com.example.kodetrainee2024.ui.screens.error.ErrorScreen
import com.example.kodetrainee2024.ui.screens.main.components.UserList
import com.example.kodetrainee2024.ui.screens.user_detail.UserDetailScreen

@Suppress("ktlint:standard:function-naming")
@Composable
fun MainScreen() {
    var text by remember { mutableStateOf("") }
    var filterByAlphabet by remember { mutableStateOf(true) }
    var initialSort by remember { mutableStateOf("По алфавиту") }
    var selectedUser by remember { mutableStateOf<User?>(null) }
    var errorState by remember { mutableStateOf<String?>(null) }

    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .background(
                    color = Color.White,
                ),
    ) {
        if (errorState != null) {
            ErrorScreen(onRetry = {
                errorState = null
            })
        } else {
            if (selectedUser != null) {
                UserDetailScreen(user = selectedUser!!, onBack = { selectedUser = null })
            } else {
                EditTextField(
                    hint = "Введи имя, тег, почту...",
                    value = text,
                    onValueChange = { text = it },
                    clearText = "Отмена",
                    onFilterAlphabetSelected = { filterByAlphabet = it },
                    initialSort = initialSort,
                    onSortSelected = { initialSort = it },
                )

                if (selectedUser == null) {
                    UserList(
                        api = HttpClient.api,
                        filterByAlphabet = filterByAlphabet,
                        searchQuery = text,
                        onUserSelected = {
                            selectedUser = it
                        },
                        onError = { errorState = it },
                    )
                }
            }
        }
    }
}
