tasks.named("bootJar").configure { enabled = true } // ✅ bootJar 비활성화 (Spring Boot 실행 파일 X)
tasks.named("jar").configure { enabled = false}

dependencies {
    implementation(project(":drive-application"))
    implementation(project(":drive-infra:storage"))
    implementation(project(":drive-infra:persistence"))
    implementation("org.springframework.boot:spring-boot-starter-validation")
}