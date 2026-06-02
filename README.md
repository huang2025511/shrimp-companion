# 虾仁AI伴侣 - Android应用

## 📱 项目介绍

一个可爱的沙雕风格Android AI聊天应用，使用虾仁表情包角色作为界面形象。

### 功能特性
- 🦐 虾仁角色动画展示
- 💬 AI智能聊天对话
- 🎨 Material Design 3 界面
- 📱 响应式设计

## 🛠️ 技术栈

- **语言**: Kotlin
- **UI框架**: Jetpack Compose
- **AI服务**: OpenAI API (可配置)
- **动画**: Compose Animation
- **网络**: Retrofit + OkHttp

## 📋 构建要求

- JDK 17+
- Android SDK API 34
- Gradle 8.0+
- Android Studio Hedgehog (推荐)

## 🚀 快速开始

### 1. 克隆项目

```bash
git clone https://gitee.com/huang20260511/shrimp-companion.git
cd shrimp-companion
```

### 2. 配置API Key

在 `app/gradle.properties` 中配置你的 OpenAI API Key:

```properties
API_KEY=your_openai_api_key_here
```

### 3. 构建项目

```bash
# 使用 Gradle Wrapper
./gradlew assembleDebug

# 或使用 Android Studio 打开项目直接构建
```

### 4. 安装APK

生成的Debug APK位置：

```
app/build/outputs/apk/debug/app-debug.apk
```

## 📁 项目结构

```
app/src/main/java/com/example/shrimpcompanion/
├── data/              # 数据层
│   ├── AiApiService.kt
│   ├── AiRepository.kt
│   ├── AiResponse.kt
│   └── Message.kt
├── ui/                # 界面层
│   ├── ChatBubble.kt
│   ├── MainScreen.kt
│   ├── MessageInput.kt
│   ├── ShrimpCharacter.kt
│   └── UiPreview.kt
├── viewmodel/         # 视图模型层
│   └── ChatViewModel.kt
└── MainActivity.kt    # 主活动
```

## 🎨 自定义角色

你可以替换 `app/src/main/res/drawable/shrimp_character.xml` 中的矢量图来自定义虾仁角色形象。

## 📄 License

MIT License
