# Gitee CI/CD 构建APK指南

## 🎯 快速开始

### 方式一：使用 GitHub Actions 格式配置（推荐）

1. 确保仓库中已有 `.gitee/workflows/build-apk.yml` 文件
2. 推送到Gitee后，在 Gitee 仓库页面 -> 服务 -> 工作流 -> 启用工作流
3. 每次 push 代码到 master 分支，或手动触发构建

### 方式二：使用 Gitee Go 原生配置

Gitee Go 是 Gitee 的原生 CI/CD 服务：

1. 在 Gitee 仓库页面 -> 服务 -> Gitee Go
2. 开启 Gitee Go 服务
3. 配置使用 `.gitee/go.yml` 作为配置文件

## 📦 如何获取构建好的APK

构建完成后：

1. 进入 Gitee 仓库页面 -> 服务 -> 工作流
2. 选择对应的运行记录
3. 点击「构建记录」->「Artifacts」
4. 下载 `app-debug` 或 `app-release-unsigned` 文件

## 🔧 配置说明

### 工作流触发条件

- **Push 到 master 分支**: 自动触发构建
- **Pull Request**: PR 更新时自动构建
- **手动触发**: 在工作流页面点击「运行工作流」

### 构建内容

每次构建会生成：

- **Debug APK**: `app-debug.apk` - 用于开发测试
- **Release APK**: `app-release-unsigned.apk` - 未签名的发布版本

## 🚀 第一次使用Gitee CI

1. 在 Gitee 仓库中，进入「服务」菜单
2. 找到「工作流」或「Gitee Go」服务
3. 点击「启用」
4. 授权访问权限
5. 完成！

## 📋 常见问题

### Q: 构建失败怎么办？

A: 查看工作流日志，常见问题：
- 网络问题导致依赖下载失败 - 重新运行即可
- 权限问题 - 确保有仓库的完全访问权限

### Q: 如何签名Release APK？

A: Release APK默认未签名，要签名请在项目中配置keystore并在构建时签名。

### Q: 构建速度慢？

A: GitHub Actions 格式通常有更稳定的网络，推荐优先使用 `.gitee/workflows/build-apk.yml` 配置。
