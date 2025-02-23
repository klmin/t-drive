import org.springframework.boot.gradle.tasks.bundling.BootJar

tasks{
    named<BootJar>("bootJar"){
        enabled = false
    }
    named<Jar>("jar") {
        enabled = true
    }
}

val awsSdkVersion: String by project

dependencies {
    implementation(project(":drive-domain"))
    implementation("software.amazon.awssdk:s3:$awsSdkVersion")
}