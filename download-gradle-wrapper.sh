#!/bin/bash

# Download Gradle wrapper JAR
GRADLE_WRAPPER_JAR="gradle/wrapper/gradle-wrapper.jar"
GRADLE_VERSION="8.0"

# Create directory if not exists
mkdir -p gradle/wrapper

# Download from Gradle's official repo
echo "Downloading Gradle Wrapper JAR..."
curl -L -o "$GRADLE_WRAPPER_JAR" "https://raw.githubusercontent.com/gradle/gradle/v${GRADLE_VERSION}/gradle/wrapper/gradle-wrapper.jar"

if [ -f "$GRADLE_WRAPPER_JAR" ]; then
    echo "Successfully downloaded Gradle Wrapper JAR"
    ls -lh "$GRADLE_WRAPPER_JAR"
else
    echo "Failed to download Gradle Wrapper JAR"
    exit 1
fi
