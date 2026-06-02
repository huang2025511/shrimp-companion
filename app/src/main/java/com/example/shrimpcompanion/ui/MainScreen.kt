package com.example.shrimpcompanion.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.shrimpcompanion.data.Message
import com.example.shrimpcompanion.viewmodel.ChatViewModel

@Composable
fun MainScreen() {
    val context = LocalContext.current
    val viewModel = remember { ChatViewModel(context) }
    val messages = viewModel.messages.value
    val isLoading = viewModel.isLoading.value
    val errorMessage = viewModel.errorMessage.value
    val snackbarHostState = remember { SnackbarHostState() }
    
    val listState = rememberLazyListState()
    
    LaunchedEffect(messages.size) {
        listState.scrollToItem(messages.size - 1)
    }
    
    LaunchedEffect(errorMessage) {
        if (errorMessage != null) {
            snackbarHostState.showSnackbar(errorMessage)
            viewModel.clearError()
        }
    }
    
    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        bottomBar = {
            MessageInput(
                onSend = { viewModel.sendMessage(it) },
                isLoading = isLoading
            )
        }
    ) { padding ->
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(bottom = 80.dp)
            ) {
                ShrimpCharacter(onClick = {
                    viewModel.sendMessage("你好！")
                })
                
                LazyColumn(
                    state = listState,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 8.dp)
                ) {
                    items(messages) { message ->
                        ChatBubble(
                            text = message.text,
                            isUser = message.isUser
                        )
                    }
                }
            }
        }
    }
}
