package com.example.shrimpcompanion.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.shrimpcompanion.R

@Composable
fun ChatBubble(
    text: String,
    isUser: Boolean
) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = if (isUser) Alignment.CenterEnd else Alignment.CenterStart
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            color = if (isUser) Color.Black else Color.White,
            textAlign = if (isUser) TextAlign.End else TextAlign.Start,
            modifier = Modifier
                .padding(8.dp)
                .widthIn(max = 280.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(
                    color = if (isUser) colorResource(id = R.color.chatBubbleUser) 
                            else colorResource(id = R.color.chatBubbleShrimp)
                )
                .padding(12.dp)
        )
    }
}
