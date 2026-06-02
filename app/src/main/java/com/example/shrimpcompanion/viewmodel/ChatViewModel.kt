package com.example.shrimpcompanion.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shrimpcompanion.data.AiRepository
import com.example.shrimpcompanion.data.ChatMessage
import com.example.shrimpcompanion.data.Message
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.UUID

class ChatViewModel(context: Context) : ViewModel() {
    private val aiRepository = AiRepository(context)
    
    private val _messages = MutableStateFlow<List<Message>>(listOf())
    val messages: StateFlow<List<Message>> = _messages.asStateFlow()
    
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()
    
    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage.asStateFlow()
    
    private val chatHistory = mutableListOf<ChatMessage>()

    init {
        addInitialMessage()
    }

    private fun addInitialMessage() {
        val initialMessage = Message(
            id = UUID.randomUUID().toString(),
            text = "你好啊！我是你的虾仁AI伴侣~ 有什么想聊的吗？",
            isUser = false
        )
        _messages.value = listOf(initialMessage)
        chatHistory.add(ChatMessage(role = "assistant", content = initialMessage.text))
    }

    fun sendMessage(text: String) {
        if (text.isBlank()) return
        
        _isLoading.value = true
        _errorMessage.value = null
        
        val userMessage = Message(
            id = UUID.randomUUID().toString(),
            text = text,
            isUser = true
        )
        
        _messages.value = _messages.value + userMessage
        chatHistory.add(ChatMessage(role = "user", content = text))
        
        viewModelScope.launch {
            val response = aiRepository.getResponse(chatHistory)
            
            _isLoading.value = false
            
            if (response != null) {
                val aiMessage = Message(
                    id = UUID.randomUUID().toString(),
                    text = response,
                    isUser = false
                )
                _messages.value = _messages.value + aiMessage
                chatHistory.add(ChatMessage(role = "assistant", content = response))
            } else {
                _errorMessage.value = "网络连接失败，请稍后重试"
            }
        }
    }
    
    fun clearError() {
        _errorMessage.value = null
    }
}
