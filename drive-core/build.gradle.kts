tasks.named("bootJar").configure { enabled = false } // ✅ bootJar 비활성화 (Spring Boot 실행 파일 X)
tasks.named("jar").configure { enabled = true }

dependencies {

}