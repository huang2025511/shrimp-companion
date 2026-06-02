package com.example.shrimpcompanion.data

data class AiResponse(
    val choices: List<Choice>
)

data class Choice(
    val message: ChatMessage
)

data class ChatMessage(
    val role: String,
    val content: String
)

data class ChatRequest(
    val model: String = "gpt-3.5-turbo",
    val messages: List<ChatMessage>
)
