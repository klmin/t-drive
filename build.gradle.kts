plugins {
    java
    id("org.springframework.boot") apply false
    id("io.spring.dependency-management") apply false
}

tasks.withType<Jar> {
    enabled = false
}

val projectGroup: String by project
val applicationVersion: String by project
val javaVersion = project.findProperty("javaVersion").toString().toInt()

allprojects {

    group = projectGroup
    version = applicationVersion

    repositories {
        mavenCentral()
    }
}

subprojects{

    apply(plugin = "java")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.springframework.boot")

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
        implementation("org.springframework.boot:spring-boot-starter-web")
        compileOnly("org.projectlombok:lombok")
        annotationProcessor("org.projectlombok:lombok")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    }

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(javaVersion))
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    configurations {
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }
}








