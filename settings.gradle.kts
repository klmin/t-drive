rootProject.name = "t-drive"

include(
    "drive-bootstrap",
    "drive-api",
    "drive-domain",
    "drive-application",
    "drive-infra:persistence:jpa",
    "drive-infra:persistence:mybatis",
    "drive-infra:database:mysql",
    "drive-infra:database:redis",
    "drive-infra:storage"
)

pluginManagement {

    val springBootVersion: String by settings
    val springDependencyManagementVersion: String by settings

    plugins {
        id("org.springframework.boot") version springBootVersion
        id("io.spring.dependency-management") version springDependencyManagementVersion
    }
}

