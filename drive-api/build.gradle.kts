import org.springframework.boot.gradle.tasks.bundling.BootJar

tasks{
    named<BootJar>("bootJar"){
        enabled = false
    }
    named<Jar>("jar") {
        enabled = true
    }
}
dependencies {
    implementation(project(":drive-application"))
    implementation("org.springframework.boot:spring-boot-starter-validation")
}