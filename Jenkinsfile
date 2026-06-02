pipeline {
  agent any
  
  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }
    
    stage('Setup JDK') {
      steps {
        sh 'which java'
        sh 'java -version'
      }
    }
    
    stage('Build APK') {
      steps {
        script {
          try {
            sh 'chmod +x ./gradlew'
            sh './gradlew assembleDebug --stacktrace --no-daemon'
          } catch (Exception e) {
            echo "Build failed, trying system Gradle..."
            sh 'gradle wrapper --gradle-version 8.4'
            sh './gradlew assembleDebug --stacktrace --no-daemon'
          }
        }
      }
    }
    
    stage('Archive APK') {
      steps {
        script {
          if (fileExists('app/build/outputs/apk/debug/app-debug.apk')) {
            archiveArtifacts artifacts: 'app/build/outputs/apk/debug/app-debug.apk', fingerprint: true
          }
        }
      }
    }
  }
  
  environment {
    JAVA_HOME = tool name: 'JDK17', type: 'hudson.model.JDK'
  }
}
