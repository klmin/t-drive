import org.springframework.boot.gradle.tasks.bundling.BootJar

tasks{
    named<BootJar>("bootJar"){
        enabled = false
    }
    named<Jar>("jar") {
        enabled = true
    }
}

val mapStructVersion: String by project
val myBatisVersion: String by project

dependencies {
    implementation(project(":drive-domain"))
    implementation("org.mapstruct:mapstruct:$mapStructVersion")
    annotationProcessor("org.mapstruct:mapstruct-processor:$mapStructVersion")
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:$myBatisVersion")
    testImplementation("org.mybatis.spring.boot:mybatis-spring-boot-starter-test:$myBatisVersion")
}
