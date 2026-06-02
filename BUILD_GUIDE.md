# 🚀 Gitee构建APK操作指南

## ⚠️ 重要提示

Gitee的CI/CD服务需要**手动启用**后才能自动构建APK。

## 📋 操作步骤

### 第一步：启用Gitee工作流

1. 打开浏览器，访问：
   **https://gitee.com/huang20260511/shrimp-companion**

2. 点击顶部菜单 **「服务」**

3. 找到以下选项之一并点击：
   - **「工作流」** (推荐) - 支持GitHub Actions格式
   - **「Gitee Go」** - Gitee原生CI服务

4. 点击 **「启用」** 或 **「开启服务」**

5. 授权访问权限

### 第二步：触发构建

启用后，有两种方式触发构建：

#### 方式A：手动触发
1. 在工作流页面，点击 **「运行工作流」**
2. 选择 `master` 分支
3. 点击 **「运行」**

#### 方式B：推送代码触发
- 每次push代码到master分支会自动触发构建

### 第三步：查看构建进度

1. 在工作流页面查看构建状态
2. 点击构建记录查看详细日志
3. 等待构建完成（约5-10分钟）

### 第四步：下载APK

构建完成后：

1. 进入构建记录详情页
2. 找到 **「Artifacts」** 或 **「构建产物」**
3. 下载以下文件：
   - `app-debug.apk` - 调试版本（推荐）
   - `app-release-unsigned.apk` - 未签名发布版本

## 🔧 已配置的工作流文件

项目已包含以下CI配置：

| 文件 | 用途 |
|------|------|
| `.gitee/workflows/build-apk.yml` | GitHub Actions格式（推荐） |
| `.gitee/go.yml` | Gitee Go原生格式 |

## ❓ 常见问题

### Q: 找不到「服务」菜单？
A: 确保您已登录Gitee账号，并且是仓库的所有者或管理员。

### Q: 工作流启用后没有运行？
A: 尝试手动触发，或者推送一个新的commit。

### Q: 构建失败怎么办？
A: 
1. 查看构建日志了解错误原因
2. 常见问题是网络超时，重新运行即可
3. 确保项目配置正确

## 📱 项目信息

- **仓库地址**: https://gitee.com/huang20260511/shrimp-companion
- **默认分支**: master
- **APK输出**: `app/build/outputs/apk/debug/app-debug.apk`

---

**提示**: 如果Gitee CI无法使用，您也可以在本地电脑上克隆项目并使用Android Studio构建APK。
