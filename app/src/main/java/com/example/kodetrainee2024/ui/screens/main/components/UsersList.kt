package com.example.kodetrainee2024.ui.screens.main.components

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.kodetrainee2024.data.http_client.Api
import com.example.kodetrainee2024.data.http_client.models.User

@Suppress("ktlint:standard:function-naming")
@Composable
fun UserList(
    api: Api,
    filterByAlphabet: Boolean,
    searchQuery: String,
    onUserSelected: (User) -> Unit,
    onError: (String) -> Unit,
) {
    var usersState by remember { mutableStateOf<List<User>>(emptyList()) }

    LaunchedEffect(Unit) {
        try {
            val response = api.getUsers()
            usersState = response.items
        } catch (e: Exception) {
            Log.e("UserList", "Error fetching users", e)
            onError("Ошибка: $e")
        }
    }

    val tabs = Tabs.values().toList()

    var selectedTabIndex by remember { mutableStateOf(0) }

    Column {
        TabsHeaders(
            tabs = tabs,
            selectedTabIndex = selectedTabIndex,
            onTabSelected = { selectedTabIndex = it },
        )
    }

    LazyColumn {
        val filteredUsers =
            if (tabs[selectedTabIndex] == Tabs.All) {
                usersState
            } else {
                usersState.filter { it.department == tabs[selectedTabIndex].text }
            }
        val sortedUsers =
            if (filterByAlphabet) {
                filteredUsers.sortedWith(compareBy<User> { it.firstName }.thenBy { it.lastName })
            } else {
                filteredUsers.sortedBy { it.birthday }
            }
        val searchedUsers =
            sortedUsers.filter {
                it.firstName.contains(searchQuery, ignoreCase = true) ||
                    it.lastName.contains(searchQuery, ignoreCase = true) ||
                    it.userTag.contains(searchQuery, ignoreCase = true)
            }
        if (searchedUsers.isEmpty()) {
            item {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Поиск",
                        )
                        Text(text = "Пусто")
                    }
                }
            }
        } else {
            items(searchedUsers) { user ->
                UserCard(user = user, onClick = { onUserSelected(user) })
            }
        }
    }
}
