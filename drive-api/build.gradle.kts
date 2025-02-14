tasks.named("bootJar").configure { enabled = false }
tasks.named("jar").configure { enabled = true}

dependencies {
    implementation(project(":drive-application"))
    implementation("org.springframework.boot:spring-boot-starter-validation")
}