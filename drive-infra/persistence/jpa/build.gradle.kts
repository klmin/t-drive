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
    implementation(project(":drive-domain"))
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.4")
    testImplementation("org.mybatis.spring.boot:mybatis-spring-boot-starter-test:3.0.4")
}