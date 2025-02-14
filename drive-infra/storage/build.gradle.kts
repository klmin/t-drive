tasks.named("bootJar").configure { enabled = false }
tasks.named("jar").configure { enabled = true }

dependencies {
    implementation(project(":drive-domain"))
}