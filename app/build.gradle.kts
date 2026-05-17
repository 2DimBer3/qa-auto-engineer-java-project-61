plugins {
    application
    checkstyle
    id("com.github.ben-manes.versions") version "0.53.0"
    id("org.sonarqube") version "7.2.3.7755"
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass = "hexlet.code.App"
}

sonar {
    properties {
        property("sonar.projectKey", "2DimBer3_qa-auto-engineer-java-project-61")
        property("sonar.organization", "2dimber3")
    }
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}