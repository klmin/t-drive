import org.springframework.boot.gradle.tasks.bundling.BootJar

tasks{
	named<BootJar>("bootJar"){
		archiveBaseName.set("t-drive")
		enabled = true
	}
	named<Jar>("jar") {
		enabled = false
	}
}

dependencies {
	implementation(project(":drive-api"))
	implementation(project(":drive-application"))
	implementation(project(":drive-domain"))
	implementation(project(":drive-infra:storage"))
	implementation(project(":drive-infra:persistence"))
	implementation("org.springframework.boot:spring-boot-docker-compose")
}