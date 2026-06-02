package com.example.shrimpcompanion.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.shrimpcompanion.R

@Composable
fun MessageInput(
    onSend: (String) -> Unit,
    isLoading: Boolean
) {
    var text by remember { mutableStateOf(TextFieldValue()) }
    
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .clip(RoundedCornerShape(24.dp))
                .background(Color(0xFF2d3436))
                .padding(horizontal = 16.dp)
        ) {
            BasicTextField(
                value = text,
                onValueChange = { text = it },
                textStyle = TextStyle(color = Color.White),
                placeholder = {
                    Text(
                        text = "跟我说点什么吧...",
                        color = Color.Gray
                    )
                },
                modifier = Modifier.padding(vertical = 12.dp),
                maxLines = 5,
                onImeActionPerformed = { _, _ ->
                    if (text.text.isNotBlank()) {
                        onSend(text.text)
                        text = TextFieldValue()
                    }
                }
            )
        }
        
        Box(
            modifier = Modifier
                .padding(start = 8.dp)
                .size(48.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary)
                .clickable {
                    if (text.text.isNotBlank() && !isLoading) {
                        onSend(text.text)
                        text = TextFieldValue()
                    }
                },
            contentAlignment = Alignment.Center
        ) {
            if (isLoading) {
                Text(text = "...", color = Color.White)
            } else {
                Icon(
                    painter = painterResource(id = R.drawable.ic_send),
                    contentDescription = "发送",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}
